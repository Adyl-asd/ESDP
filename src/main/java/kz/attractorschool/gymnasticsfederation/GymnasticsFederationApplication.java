package kz.attractorschool.gymnasticsfederation;

import kz.attractorschool.gymnasticsfederation.configuration.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class GymnasticsFederationApplication {

    public static void main(String[] args) {
        SpringApplication.run(GymnasticsFederationApplication.class, args);
    }

}
