package com.example.oats;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity  {
//    DrawerLayout drawerLayout;
//    ActionBarDrawerToggle actionBarDrawerToggle;
//    Toolbar toolbar;
//    NavigationView navigationView;
//    FragmentManager fragmentManager;
//    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        drawerLayout = findViewById(R.id.drawer);
//        navigationView = findViewById(R.id.navigationView);
//        navigationView.setNavigationItemSelectedListener(this);
//        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
//        drawerLayout.addDrawerListener(actionBarDrawerToggle);
//        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
//        actionBarDrawerToggle.syncState();

        //load default fragment
//        fragmentManager = getSupportFragmentManager();
//        fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.add(R.id.container_fragment,new FragmentSecond());
//        fragmentTransaction.commit();


        //this code will pause the app for 1.5 secs
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                isFirstTime();
            }
        },1500 );
    }

    private void isFirstTime() {
        //para sa onboard design pwede din to sa remember me function
        SharedPreferences preferences = getApplication().getSharedPreferences("onBoard", Context.MODE_PRIVATE);
        boolean isFirstTime = preferences.getBoolean("isFirstTime", true);

        if (isFirstTime) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("isFirstTime", false);
            editor.apply();

            startActivity(new Intent(MainActivity.this, OnBoardActivity.class));
            finish();
        } else {
//            startActivity(new Intent(MainActivity.this,Dashboard.class));
//            finish();
//           Intent intent = new Intent(this, MainActivity.class);

            Intent home = new Intent(getApplicationContext(),Dashboard.class);
            startActivity(home);
            finish();

        }
    };

//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
////        if (menuItem.getItemId() == R.id.home){
//////                    fragmentManager = getSupportFragmentManager();
//////                    fragmentTransaction = fragmentManager.beginTransaction();
//////                    fragmentTransaction.add(R.id.container_fragment,new FragmentSecond());
//////                    fragmentTransaction.commit();
////        }
////
////        if (menuItem.getItemId() == R.id.books){
////
////        }
////
////        if (menuItem.getItemId() == R.id.transaction){
////
////        }
////
////        if (menuItem.getItemId() == R.id.search){
////
////        }
//        return true;
//    }
}

