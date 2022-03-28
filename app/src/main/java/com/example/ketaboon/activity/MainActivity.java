package com.example.ketaboon.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
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

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
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

    MeowBottomNavigation meowBottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawerlayout);

        toolbar = (Toolbar) findViewById(R.id.toolbaramir);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        setupviews();
        confignavigationview();
        configbuttonnavigationview2();
        getSupportFragmentManager().beginTransaction().replace(R.id.fram, new Homefragment()).commit();
    }

    private void configbuttonnavigationview2() {
        meowBottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_home));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_search));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_person_pin));

        meowBottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {

            }
        });

        meowBottomNavigation.setCount(1, "10");
        meowBottomNavigation.show(1, true);
        meowBottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                int ali = item.getId();
                switch (ali) {

                    case 1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fram, new Homefragment()).commit();
                        break;
                    case 2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fram, new Searchefragment()).commit();
                        break;
                    case 3:

                        getSupportFragmentManager().beginTransaction().replace(R.id.fram, new Profilefragment()).commit();

                        break;

                }

            }
        });
        meowBottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
                int ali = item.getId();
                switch (ali) {

                    case 1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fram, new Homefragment()).commit();
                        break;
                    case 2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fram, new Searchefragment()).commit();
                        break;
                    case 3:

                        getSupportFragmentManager().beginTransaction().replace(R.id.fram, new Profilefragment()).commit();

                        break;

                }
            }
        });

    }

    private void setupviews() {
        // b1_nav = (BottomNavigationView) findViewById(R.id.btn_nav);
        frameLayout = (FrameLayout) findViewById(R.id.fram);
        navigationView = (NavigationView) findViewById(R.id.nav_main);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        imageButton = (ImageView) findViewById(R.id.nav_btn);
        meowBottomNavigation = (MeowBottomNavigation) findViewById(R.id.btn_najv);
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

                    case R.id.home_btn_a:

                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://iamnovinfar.ir"));
                        startActivity(intent);
                        break;
                    case R.id.Source:


                        Dialog dialog=new Dialog(MainActivity.this);
                        dialog.setContentView(R.layout.source_page);

                        TextView textView=dialog.findViewById(R.id.resiurce);
                        textView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String url = "https://www.iamnovinfar.ir";
                                Intent i = new Intent(Intent.ACTION_VIEW);
                                i.setData(Uri.parse(url));
                                startActivity(i);
                            }
                        });


                        dialog.show();


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



























