package ir.iamnovinfar.ketaboon.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ir.iamnovinfar.ketaboon.Database.Database;
import com.example.ketaboon.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sdsmdg.tastytoast.TastyToast;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class ContentActivity extends AppCompatActivity {
    ImageView back;
    CircleImageView imageView;
    TextView name_txt,field_txt,disc_txt;
    FloatingActionButton floatingActionButton;
    Database db;
    int value,id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        setupviews();
        setupdata();
        favcondition();
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addorremovefav();
            }
        });

    }

    private void setupviews() {
        back=findViewById(R.id.back);
        imageView= findViewById(R.id.img_id2);
        name_txt= findViewById(R.id.name_id_content);
        field_txt= findViewById(R.id.fild_id_content);
        disc_txt= findViewById(R.id.disk2_danshmand);
        disc_txt.setMovementMethod(new ScrollingMovementMethod());


        floatingActionButton= findViewById(R.id.fav_btn);
    }
    private void setupdata(){
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
        id= intent.getExtras().getInt("id");
        Picasso.Builder picasso=new Picasso.Builder(this);


        Picasso.get().load(img).error(R.drawable.user_error).into(imageView);
        name_txt.setText(name);
        field_txt.setText(field);
        disc_txt.setText(disk);
    }
    private void favcondition(){
        db=new Database(ContentActivity.this);
        value=db.fav_value(id);
        if (value==0){
            floatingActionButton.setImageResource(R.drawable.ic_favorite_border_black_24dp);
        }

        else if (value==1){
            floatingActionButton.setImageResource(R.drawable.ic_favorite_black_24dp);

        }
    }
    private void addorremovefav(){
        db=new Database(ContentActivity.this);
        value=db.fav_value(id);

        if (value==0){
            db.fav(1,id);
            floatingActionButton.setImageResource(R.drawable.ic_favorite_black_24dp);
            TastyToast.makeText(this,"به لیست علاقه مندی ها اضافه شد " ,TastyToast.LENGTH_LONG,TastyToast.SUCCESS);
        }else {
            db.fav(0,id);
            floatingActionButton.setImageResource(R.drawable.ic_favorite_border_black_24dp);
            TastyToast.makeText(this,"از لیست علاقه مندی ها حذف شد  " ,TastyToast.LENGTH_LONG,TastyToast.SUCCESS);
        }
    }



}
