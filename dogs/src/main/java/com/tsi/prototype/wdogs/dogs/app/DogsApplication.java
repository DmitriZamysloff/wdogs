package com.tsi.prototype.wdogs.dogs.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@SpringBootApplication
@EnableJpaRepositories("com.tsi.prototype.wdogs.dogs.dao")
@EntityScan("com.tsi.prototype.wdogs.dogs.model")
public class DogsApplication implements CommandLineRunner {

    @Autowired
    DataSource dataSource;

    public static void main(String ... args) {
        SpringApplication.run(DogsApplication.class, args);
    }

    public void run(String... args) throws Exception {
        System.out.println("Data source = " + dataSource);

    }
}
