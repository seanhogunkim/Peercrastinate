package com.example.peercrastinationapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.peercrastinationapp.ui.myprofile.SignupFragment;

public class SignupActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        openFragment(new SignupFragment(this));

    }

    public void openFragment(Fragment selectedFragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_signup, selectedFragment).commit();
    }

    public void switchActivities(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME);
        startActivity(intent);
        this.finish();
    }
}
