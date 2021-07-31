package com.example.peercrastinationapp;

import static android.app.AppOpsManager.OPSTR_GET_USAGE_STATS;

import android.app.AppOpsManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.os.Process;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.peercrastinationapp.databinding.ActivityMainBinding;

import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        if(!checkForPermission(this)){
            startActivity(new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS));
        }

        UsageStatsManager usm = (UsageStatsManager) this.getSystemService(Context.USAGE_STATS_SERVICE);
        final int currentYear=Calendar.getInstance().get(Calendar.YEAR);
        final List<UsageStats> queryUsageStats=usm.queryUsageStats(UsageStatsManager.INTERVAL_YEARLY,currentYear-2,currentYear);
        Log.d("myTag", queryUsageStats.get(0).toString());
    }

    private boolean checkForPermission(Context context) {
        AppOpsManager appOps = (AppOpsManager) context.getSystemService(Context.APP_OPS_SERVICE);
        int mode = appOps.checkOpNoThrow(OPSTR_GET_USAGE_STATS, Process.myUid(), context.getPackageName());
        return mode == AppOpsManager.MODE_ALLOWED;
    }

}