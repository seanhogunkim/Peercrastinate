package com.example.peercrastinationapp.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.peercrastinationapp.ui.entities.Game;
import com.example.peercrastinationapp.ui.entities.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Dashboard is currently being used as a tester for the Game class, everything here can be changed.
 */
public class DashboardViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    User user = new User("peepo");
    User one = new User("popo");
    User two = new User("hehexd");
    Game game = new Game(user);
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

    public DashboardViewModel() {
        game.addUser(one);
        game.addUser(two);
        mText = new MutableLiveData<>();
        mText.setValue("Lobby Code: " + game.getGameID()
                + "\nStart Time: " + dateFormat.format(game.getStartDate())
                + "\nEnd Time: " + dateFormat.format(game.getEndDate())
                + "\nHost Name: " + game.getHost().get_name()
                + "\nPot: $" + Integer.toString(game.getPot())
        );
    }

    public LiveData<String> getText() {
        return mText;
    }
}