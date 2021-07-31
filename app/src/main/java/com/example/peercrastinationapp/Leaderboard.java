package com.example.peercrastinationapp;

import org.bson.types.ObjectId;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Leaderboard extends RealmObject {
    @PrimaryKey
    private ObjectId _id = new ObjectId();

    private String player_id = "name";

    private double time = 0;

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(String player_id) {
        this.player_id = player_id;
    }

    public void setTime(double _time) {
        this.time = _time;
    }

    public double getTime() {
        return time;
    }

    public Leaderboard(String _player_id) {
        this.player_id = _player_id;
    }

    public Leaderboard() {
    }
}
