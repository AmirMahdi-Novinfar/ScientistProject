package ir.iamnovinfar.ketaboon.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ketaboon.R;

public class Splashactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashactivity);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        SharedPreferences sharedPreferences = getSharedPreferences("Login", MODE_PRIVATE);
        boolean ISLOGIN = sharedPreferences.getBoolean("isLogin", false);

        if (ISLOGIN == true) {
            Handler jh = new Handler();
            jh.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (!havenetwork()) {
                        final AlertDialog.Builder builder = new AlertDialog.Builder(Splashactivity.this);
                        builder.setCancelable(false);
                        builder.setTitle("خطا در شبکه");
                        builder.setMessage("لطفا گوشی خود را به اینترنت مجهز نمایید.");
                        builder.setIcon(R.drawable.networkerror);
                        builder.setPositiveButton("خروج", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        });

                        builder.setNeutralButton("تلاش دوباره", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (!havenetwork()) {
                                    builder.show();
                                } else if (havenetwork()) {
                                    startActivity(new Intent(Splashactivity.this, MainActivity.class));
                                    dialogInterface.cancel();
                                    finish();
                                }
                            }
                        });

                        builder.setNegativeButton("ورود به صورت آفلاین", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(Splashactivity.this, MainActivity.class));
                                dialogInterface.cancel();
                                finish();
                            }
                        });

                        builder.show();
                    } else {
                        startActivity(new Intent(Splashactivity.this, MainActivity.class));
                        finish();
                    }
                }
            }, 2000);


        } else if (ISLOGIN == false) {

            Handler jh = new Handler();
            jh.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (!havenetwork()) {
                        final AlertDialog.Builder builder = new AlertDialog.Builder(Splashactivity.this);
                        builder.setCancelable(false);
                        builder.setTitle("خطا در شبکه");
                        builder.setMessage("لطفا گوشی خود را به اینترنت مجهز نمایید.");
                        builder.setIcon(R.drawable.networkerror);
                        builder.setNegativeButton("خروج", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        });

                        builder.setNeutralButton("تلاش دوباره", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (!havenetwork()) {
                                    builder.show();
                                } else if (havenetwork()) {
                                    startActivity(new Intent(Splashactivity.this, LoginActivity.class));
                                    dialogInterface.cancel();
                                    finish();
                                }
                            }
                        });

                        builder.setPositiveButton("ورود به صورت آفلاین", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(Splashactivity.this, LoginActivity.class));
                                dialogInterface.cancel();
                                finish();
                            }
                        });
                        builder.show();
                    }else {
                        startActivity(new Intent(Splashactivity.this, LoginActivity.class));
                        finish();
                    }
                }
            }, 6000);
        }
    }


    private boolean havenetwork() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        final NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        } else {
            return false;
        }
    }
}
