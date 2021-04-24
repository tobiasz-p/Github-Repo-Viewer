package com.pauter.githubrepoviewer.rest;

import com.pauter.githubrepoviewer.app.GithubRepoViewerApplication;
import com.pauter.githubrepoviewer.logic.Repository;
import com.pauter.githubrepoviewer.logic.StarsCounter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class GithubRepoViewerController {

    private static final Logger log = LoggerFactory.getLogger(GithubRepoViewerApplication.class);

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<Repository> getRepositoriesInfo(@PathVariable("userId") String userId) {
        ResponseEntity<List<Repository>> rateResponse =
                restTemplate.exchange("https://api.github.com/users/" + userId + "/repos",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Repository>>() {
                        });
        List<Repository> repositoryList = rateResponse.getBody();
        log.info(repositoryList.toString());
        return repositoryList;
    }

    @RequestMapping("/{userId}/stars")
    public int getUserStarsCount(@PathVariable("userId") String userId) {
        ResponseEntity<List<Repository>> rateResponse =
                restTemplate.exchange("https://api.github.com/users/" + userId + "/repos",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Repository>>() {
                        });
        List<Repository> repositoryList = rateResponse.getBody();
        if (repositoryList != null){
            StarsCounter starsCounter = new StarsCounter(repositoryList);
            return starsCounter.getAllStarsCounter();
        }
        else return 0;
    }
}
