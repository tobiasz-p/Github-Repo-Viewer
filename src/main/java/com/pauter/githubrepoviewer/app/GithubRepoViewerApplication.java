package com.pauter.githubrepoviewer.app;

import com.pauter.githubrepoviewer.logic.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication(scanBasePackages = {"com.pauter.githubrepoviewer.rest"})
public class GithubRepoViewerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GithubRepoViewerApplication.class, args);
    }


    @Bean
    public RestTemplate getRestTemplate() { return new RestTemplate(); }
}

