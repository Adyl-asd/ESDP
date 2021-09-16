package kz.attractorschool.gymnasticsfederation.configuration;



import kz.attractorschool.gymnasticsfederation.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    CommandLineRunner init(StorageService service) {
        return (args) -> {
            service.init();
        };
    }
}
