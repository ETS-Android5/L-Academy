package com.example.myapplication;

/**
 * This represents the user information
 */
public class User {
    private final String username;
    private final String password;


    private int points;

    User(String username, String password){
        this.username = username;
        this.password = password;
        this.points = 0;
    }

    String getUserName(){
        return this.username;
    }

    String getPassword(){
        return this.password;
    }
    public int getPoints() {
        return points;
    }

}
