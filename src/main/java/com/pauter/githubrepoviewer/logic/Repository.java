package com.pauter.githubrepoviewer.logic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Repository {
    private String name;
    private int stargazersCount;

    public Repository() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStargazersCount() {
        return stargazersCount;
    }

    public void setStargazersCount(int stargazersCount) {
        this.stargazersCount = stargazersCount;
    }

    @Override
    public String toString() {
        return "Repository {" +
                "name='" + name + '\'' +
                ", stars=" + stargazersCount +
                '}';
    }
}
