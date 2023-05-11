package com.example.spring.project.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
public class SpringProjectManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringProjectManagementApplication.class, args);
    }

}
