package com.example.note;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.note.about.AboutActivity;
import com.google.android.material.navigation.NavigationView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    //Navigation
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ShowNav();

    }

    //show Navigation
    private void ShowNav(){
        drawerLayout = (DrawerLayout) findViewById(R.id.main_drawerLayout);
        navigationView = (NavigationView) findViewById(R.id.navigation);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            //search
            case R.id.nav_item_about:
                //Toast.makeText(this, "About navigation button selected", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                return true;
            //view
            case R.id.nav_item_calendar:
                Toast.makeText(this, "Calendar navigation detail button selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.nav_item_setting:
                Toast.makeText(this, "Setting navigation grid button selected", Toast.LENGTH_SHORT).show();
                return true;

        }

        return false;
    }

    //show icon in menu of action bar
    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_action_bar,menu);
        if(menu instanceof MenuBuilder){
            MenuBuilder m = (MenuBuilder) menu;
            m.setOptionalIconsVisible(true);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)) {
            return true;
        }

        switch (item.getItemId()) {
            //search
            case R.id.action_bar_search:
                Toast.makeText(this, "Search button selected", Toast.LENGTH_SHORT).show();
                return true;
            //view
            case R.id.action_bar_view_detail:
                Toast.makeText(this, "view detail button selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_bar_view_grid:
                Toast.makeText(this, "view grid button selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_bar_view_list:
                Toast.makeText(this, "view list button selected", Toast.LENGTH_SHORT).show();
                return true;
            //sort
            case R.id.action_bar_sort_color:
                Toast.makeText(this, "sort color button selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_bar_sort_alphabetically:
                Toast.makeText(this, "sort alphabetically selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_bar_sort_date:
                Toast.makeText(this, "sort date button selected", Toast.LENGTH_SHORT).show();
                return true;
            //setting
            case R.id.action_bar_setting:
                Toast.makeText(this, "setting button selected", Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
