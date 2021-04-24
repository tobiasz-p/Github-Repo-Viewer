package com.pauter.githubrepoviewer.rest;

import com.pauter.githubrepoviewer.app.GithubRepoViewerApplication;
import com.pauter.githubrepoviewer.logic.Repository;
import com.pauter.githubrepoviewer.logic.RepositoryProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/{userName}")
    public String getRepositoriesInfo(@PathVariable("userName") String userName) {
        ResponseEntity<List<Repository>> rateResponse =
                restTemplate.exchange("https://api.github.com/users/" + userName + "/repos",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Repository>>() {
                        });
        List<Repository> repositoryList = rateResponse.getBody();
        log.info(repositoryList.toString());
        return repositoryList.toString();
    }

    @RequestMapping("/{userName}/stars")
    public String getUserStarsCount(@PathVariable("userName") String userName) {
        ResponseEntity<List<Repository>> rateResponse =
                restTemplate.exchange("https://api.github.com/users/" + userName + "/repos",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Repository>>() {
                        });
        List<Repository> repositoryList = rateResponse.getBody();

        RepositoryProcessor repositoryProcessor = new RepositoryProcessor(repositoryList);
        int allStars =  repositoryProcessor.getAllStarsCounter();

        return "{\"user\":\"" + userName + "\",\"stars\":" + allStars + "}";

    }
}
