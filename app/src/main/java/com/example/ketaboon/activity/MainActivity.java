package com.example.ketaboon.activity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.ketaboon.R;
import com.example.ketaboon.fragment.Homefragment;
import com.example.ketaboon.fragment.Profilefragment;
import com.example.ketaboon.fragment.Searchefragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.sdsmdg.tastytoast.TastyToast;

public class MainActivity extends AppCompatActivity {

    FrameLayout frameLayout;
    BottomNavigationView b1_nav;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawerlayout);
        toolbar = (Toolbar) findViewById(R.id.toolbaramir);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        setupviews();
        confignavigationview();
        configbuttonnavigationview();
        getSupportFragmentManager().beginTransaction().replace(R.id.fram, new Homefragment()).commit();
    }
    private void setupviews() {
        b1_nav = (BottomNavigationView) findViewById(R.id.btn_nav);
        frameLayout = (FrameLayout) findViewById(R.id.fram);
        navigationView = (NavigationView) findViewById(R.id.nav_main);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        imageButton = (ImageView) findViewById(R.id.nav_btn);
    }

    private void confignavigationview() {

        SharedPreferences sharedPreferences = getSharedPreferences("Login", MODE_PRIVATE);
        final String txtnamkke = sharedPreferences.getString("usr_name", "null");
        final String txtjon = sharedPreferences.getString("shoghl", "null");
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(Gravity.RIGHT);
                View headerView = navigationView.getHeaderView(0);
                TextView navUsername = (TextView) headerView.findViewById(R.id.txtnamemahdi);
                TextView navU = (TextView) headerView.findViewById(R.id.txtjobamir);
                navUsername.setText(txtnamkke);
                navU.setText(txtjon);
            }
        });

        navigationView.setCheckedItem(0);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int ali = item.getItemId();
                switch (ali) {

                    case R.id.home_btn_h:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fram, new Homefragment()).commit();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.home_btn_s:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fram, new Searchefragment()).commit();
                        drawerLayout.closeDrawers();

                        break;
                    case R.id.home_btn_p:

                        getSupportFragmentManager().beginTransaction().replace(R.id.fram, new Profilefragment()).commit();
                        drawerLayout.closeDrawers();
                        break;


                }
                return true;
            }
        });

    }

    private void configbuttonnavigationview() {
        b1_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int ali = item.getItemId();
                switch (ali) {

                    case R.id.home_btn_h:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fram, new Homefragment()).commit();
                        break;
                    case R.id.home_btn_s:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fram, new Searchefragment()).commit();
                        break;
                    case R.id.home_btn_p:

                        getSupportFragmentManager().beginTransaction().replace(R.id.fram, new Profilefragment()).commit();

                        break;

                }


                return true;
            }
        });
    }
}



























