package com.pauter.githubrepoviewer.logic;

import java.util.List;

public class RepositoryProcessor {
    private int allStarsCounter = 0;
    private List<Repository> repositoryList;

    public RepositoryProcessor() {

    }

    public RepositoryProcessor(List<Repository> repositoryList) {
        this.repositoryList = repositoryList;
    }

    public int getAllStarsCounter() {
        for (Repository repository: repositoryList) {
            allStarsCounter += repository.getStargazersCount();
        }
        return allStarsCounter;
    }
}
