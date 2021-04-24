package com.pauter.githubrepoviewer.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = {"com.pauter.githubrepoviewer.rest"})
public class GithubRepoViewerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GithubRepoViewerApplication.class, args);
    }


    @Bean
    public RestTemplate getRestTemplate() { return new RestTemplate(); }
}

