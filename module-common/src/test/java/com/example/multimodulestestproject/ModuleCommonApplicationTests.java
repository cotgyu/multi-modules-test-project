package com.example.multimodulestestproject;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = "com.example")
@EntityScan("com.example.domain")
@EnableJpaRepositories(basePackages={"com.example.repository"})
public class ModuleCommonApplicationTests {

    public void contextLoads() {
    }

}
