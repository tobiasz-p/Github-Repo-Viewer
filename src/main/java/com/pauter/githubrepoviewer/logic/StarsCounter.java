package com.pauter.githubrepoviewer.logic;

import com.pauter.githubrepoviewer.logic.Repository;

import java.util.List;

public class StarsCounter {
    private int allStarsCounter = 0;

    public StarsCounter(List<Repository> repositoryList) {
        for (Repository repository: repositoryList) {
            allStarsCounter += repository.getStargazersCount();
        }
    }

    public int getAllStarsCounter() {
        return allStarsCounter;
    }
}
