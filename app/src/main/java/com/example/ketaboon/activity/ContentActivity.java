package com.example.ketaboon.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ketaboon.R;
import com.example.ketaboon.model.Person;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class ContentActivity extends AppCompatActivity {
    ImageView back;
    CircleImageView imageView;
    TextView name_txt,field_txt,disc_txt;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        setupviews();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        Intent intent=getIntent();
        String name= intent.getExtras().getString("name");
        String img= intent.getExtras().getString("image");
        String field= intent.getExtras().getString("field");
        String disk= intent.getExtras().getString("disk");
        Picasso.with(ContentActivity.this).load(img).into(imageView);

        name_txt.setText(name);
        field_txt.setText(field);
        disc_txt.setText(disk);
    }

    private void setupviews() {
        back=findViewById(R.id.back);
        imageView= findViewById(R.id.img_id2);
        name_txt= findViewById(R.id.name_id_content);
        field_txt= findViewById(R.id.fild_id_content);
        disc_txt= findViewById(R.id.disk2_danshmand);
    }

}
