package kz.attractorschool.gymnasticsfederation.common_service;


import kz.attractorschool.gymnasticsfederation.configuration.StorageProperties;
import kz.attractorschool.gymnasticsfederation.exception.StorageException;
import kz.attractorschool.gymnasticsfederation.exception.StorageFileNotFoundException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileSystemStorageService implements StorageService {
    private final Path rootLocation;

    public FileSystemStorageService(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }

    @Override
    public void init() {
        try{
            Files.createDirectories(rootLocation);
        }
        catch (IOException e){
            throw new StorageException("Невозможно создать хранилище", e);
        }
    }

    @Override
    public void store(MultipartFile file) {
        try{
            if (file.isEmpty()){
                throw new StorageException("Невозможно загрузить пустой файл");
            }
            Path destinationFile = this.rootLocation.resolve(
                    Paths.get(file.getOriginalFilename()))
                    .normalize().toAbsolutePath();
            if (!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())){
                throw new StorageException("Нельзя хранить файл за пределами текущего каталога");
            }
            try(InputStream stream = file.getInputStream()) {
                Files.copy(stream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            }
        }
        catch (IOException e) {
            throw new StorageException("Ошибка сохранения файла", e);
        }
    }

    @Override
    public Path load(String file) {
        return rootLocation.resolve(file);
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()){
                return resource;
            }else {
                throw  new StorageFileNotFoundException("Невозможно считать файл" + filename);
            }
        } catch (MalformedURLException e) {
            throw  new StorageFileNotFoundException("Невозможно считать файл" + filename);
        }
    }
}
