package com.example.peercrastinationapp.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.peercrastinationapp.ui.entities.Game;
import com.example.peercrastinationapp.ui.entities.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DashboardViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    User user = new User("peepo", 10);
    User one = new User("popo", 10);
    User two = new User("hehexd", 10);
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