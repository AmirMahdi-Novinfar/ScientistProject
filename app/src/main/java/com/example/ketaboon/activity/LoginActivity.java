package com.example.ketaboon.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ketaboon.R;
import com.sdsmdg.tastytoast.TastyToast;


public class LoginActivity extends Activity {

    EditText e1;
    Button b1;
    boolean isLogin = false;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Spinner s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        e1 = (EditText) findViewById(R.id.edt_name);
        b1 = (Button) findViewById(R.id.btn_login);
        s1 = (Spinner) findViewById(R.id.spinner);
        String[] ali = {"شغل خود را انتخاب کنید", "دانشجو", "کارمند", "مدیر", "آزاد", "فریلنسر", "دانش آموز"};
        ArrayAdapter<String> sp_adapter = new ArrayAdapter<>
                (LoginActivity.this, android.R.layout.simple_spinner_dropdown_item, ali);
        s1.setAdapter(sp_adapter);
        sharedPreferences = getSharedPreferences("Login", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usr_name = e1.getText().toString().trim();
                validlogin(usr_name);
            }
        });


    }

    private void validlogin(String name) {
        String shoghl_sp = s1.getSelectedItem().toString();
        if (e1.length()!=0 && s1.getSelectedItemPosition()!=0) {
            isLogin = !isLogin;
            editor.putString("usr_name", name);
            editor.putString("shoghl",shoghl_sp);
            editor.putBoolean("isLogin", isLogin);
            editor.apply();
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }
        else if (e1.length()==0 ){

           TastyToast.makeText(LoginActivity.this, "لطفا نام خود را وارد کنید.", Toast.LENGTH_LONG,TastyToast.ERROR).show();

        }else {

            if (s1.getSelectedItemPosition()==0){
                TastyToast.makeText(LoginActivity.this, "لطفا شغل خود را وارد کنید.", Toast.LENGTH_LONG,TastyToast.ERROR).show();
            }


        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }


        return super.onOptionsItemSelected(item);
    }
}
