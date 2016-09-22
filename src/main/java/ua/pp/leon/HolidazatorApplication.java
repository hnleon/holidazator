package ua.pp.leon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "ua.pp.leon.domain")
@EnableJpaRepositories(basePackages = "ua.pp.leon.domain")
public class HolidazatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(HolidazatorApplication.class, args);
    }
}
