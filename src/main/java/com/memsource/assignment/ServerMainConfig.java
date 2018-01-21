package com.memsource.assignment;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Main application configuration.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class ServerMainConfig {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ServerMainConfig.class, args);
    }
}
