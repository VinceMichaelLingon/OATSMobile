package com.example.oats;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Dashboard extends AppCompatActivity {
 private Toolbar toolbar;
 private NavigationView navigationView;
 private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.drawer_dashboard);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.navigation_open,R.string.navigation_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(listner);

    }
 private NavigationView.OnNavigationItemSelectedListener listner = new NavigationView.OnNavigationItemSelectedListener() {
     @Override
     public boolean onNavigationItemSelected(@NonNull MenuItem item) {
         int id = item.getItemId();
         switch (id){
             case R.id.home:
                 Toast.makeText(Dashboard.this, "HOME is Selected", Toast.LENGTH_SHORT).show();
//                 finish();
//                 startActivity(getIntent());
                 break;

             case R.id.books:
                 Toast.makeText(Dashboard.this, "ACTORS is Selected", Toast.LENGTH_SHORT).show();
                 Fragment FragmentSecond = new FragmentSecond();
                 getSupportFragmentManager().beginTransaction().replace(R.id.container, FragmentSecond).commit();
                 break;

             case R.id.transaction:
                 Toast.makeText(Dashboard.this, "MOVIES is Selected", Toast.LENGTH_SHORT).show();
//                        Intent movie = new Intent(getApplicationContext(),AddMovie.class);
//                        startActivity(movie);
//                        finish();
//                 Fragment Movie_Fragment=new Movie_Fragment();
//                 getSupportFragmentManager().beginTransaction().replace(R.id.container, Movie_Fragment).commit();

                 break;

             case R.id.search:
                 Toast.makeText(Dashboard.this, "PRODUCERS is Selected", Toast.LENGTH_SHORT).show();
//                 Fragment Producer_Fragment=new Producer_Fragment();
//                 getSupportFragmentManager().beginTransaction().replace(R.id.container, Producer_Fragment).commit();
                 break;

             case R.id.logout:
                 Toast.makeText(Dashboard.this, "LOGOUT is Selected", Toast.LENGTH_SHORT).show();
//                 Intent signin = new Intent(getApplicationContext(),AuthActivity.class);
//                 startActivity(signin);
//                 finish();
                 break;
         }
         drawerLayout.closeDrawer(GravityCompat.START);
         return true;
     }
 };
}