package com.example.peercrastinationapp.ui.entities;

public class User {
    private String _name;
    private int _points;
    private int _imageResource;

    private int _position;
    public User(String name){
        _name=name;
        _points = 0;
        _position=0;
        //TODO Send new user details to database, use the object itself as an identifier.
        //Make this data locally stored so each access keeps user details.
    }

    public void set_position(int i){
        _position=i;

    }

    public int get_position(){
        return _position;
    }
    public String get_name(){
        return _name;
    }

    public void set_points(int i){
        _points=i;
    }

    public int get_points(){
        return _points;
    }

    public int get_imageResource(){
        return _imageResource;
    }

    public void addPoints(int points) {
        _points += points;
    }
}
