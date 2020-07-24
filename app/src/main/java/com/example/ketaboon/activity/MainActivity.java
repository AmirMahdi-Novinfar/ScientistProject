package com.example.ketaboon.activity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.ketaboon.R;
import com.example.ketaboon.fragment.Homefragment;
import com.example.ketaboon.fragment.Profilefragment;
import com.example.ketaboon.fragment.Searchefragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.sdsmdg.tastytoast.TastyToast;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    FrameLayout frameLayout;
    BottomNavigationView b1_nav;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    TextView txt_name_amir,txt_job_novin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawerlayout);
        toolbar = (Toolbar) findViewById(R.id.toolbaramir);
        setSupportActionBar(toolbar);

        b1_nav = (BottomNavigationView) findViewById(R.id.btn_nav);
        frameLayout = (FrameLayout) findViewById(R.id.fram);
        navigationView = (NavigationView) findViewById(R.id.nav_main);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        ImageView imageButton=(ImageView) findViewById(R.id.nav_btn);

        SharedPreferences sharedPreferences=getSharedPreferences("Login",MODE_PRIVATE);
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



        b1_nav.setOnNavigationItemSelectedListener(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.fram, new Homefragment()).commit();

    }


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



}