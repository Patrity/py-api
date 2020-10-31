package com.invaders.api.model;


/*
 * @project py-api
 * @author Patrity - https://github.com/Patrity
 * Created on - 10/30/2020
 */
public class Player {

    private final String name;
    private final int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
