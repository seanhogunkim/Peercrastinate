package com.example.peercrastinationapp.ui.entities;

public class User {
    private String _name;
    private int _points;
    private int _imageResource;

    public User(String name, int points){
        _name=name;
        _points=points;
    }
    public String get_name(){
        return _name;
    }
    public int get_points(){
        return _points;
    }
    public int get_imageResource(){
        return _imageResource;
    }
}
