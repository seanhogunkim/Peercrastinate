package com.example.peercrastinationapp.ui.entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Game {

    String gameID;
    int buyIn = 10;
    int pot;
    User host;
    ArrayList<User> users;
    Date startDate;
    Date endDate;
    int duration = 7; //no. of days the game goes on for.

    public Game(User host) {
        users = new ArrayList<>();
        this.host = host;
        users.add(host);
        updatePot();

        //randomly generate gameID
        gameID = generateGameID();
        //TODO: Send gameID to database

    }

    public User getHost() {
        return host;
    }

    public int getPot() {
        return pot;
    }

    public String getGameID() {
        return gameID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void addUser(User user) {
        users.add(user);
        updatePot();
    }

    public void updatePot() {
        pot = users.size() * buyIn;
    }

    public String generateGameID() {
        String output;
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        int stringLength = 6;
        StringBuilder builder = new StringBuilder();
        Random rand = new Random();

        while (builder.length() < stringLength) {
            int index = (int) (rand.nextFloat() * chars.length());
            builder.append(chars.charAt(index));
        }
        output = builder.toString();
        return output;
    }

    public void setStartAndEndDate() {
        Calendar cal = Calendar.getInstance();
        this.startDate = new Date();
        cal.setTime(startDate);
        cal.add(Calendar.DATE,duration);
        this.endDate = cal.getTime();
    }

    public void startGame() {
        updatePot();
        setStartAndEndDate();
        //TODO: Send updated data to database: pot, start/end time, list of players
    }

}
