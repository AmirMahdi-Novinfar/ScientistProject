package com.example.ketaboon.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.example.ketaboon.model.Person;
import com.sdsmdg.tastytoast.TastyToast;

public class Database extends SQLiteOpenHelper {
    Context context;

    public Database(Context context) {
        super(context, info_db.DATABASE_NAME, null, info_db.DATABASE_VERSION);
        this.context = context;
        isdatabase();

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    private void isdatabase() {
        File check = new File(info_db.PACKAGE);
        if (check.exists()) {
        } else {
            check.mkdir();
        }
        check = context.getDatabasePath(info_db.DATABASE_NAME);

        if (check.exists()) {
        } else {
            try {
                copydatabase();
            } catch (Exception e) {
                TastyToast.makeText(context, e.getLocalizedMessage(), Toast.LENGTH_LONG, TastyToast.ERROR).show();
            }
        }
    }

    private void copydatabase() throws IOException {
        InputStream inputStream = context.getAssets().open(info_db.DATABASE_SOURSE);
        String outfilename = info_db.PACKAGE + info_db.DATABASE_NAME;
        OutputStream myoutput = new FileOutputStream(outfilename);
        byte[] buffer = new byte[1024];
        int lanth;
        while ((lanth = inputStream.read(buffer)) > 0) {
            myoutput.write(buffer, 0, lanth);

        }
        myoutput.flush();
        myoutput.close();
        inputStream.close();

    }


    public List<Person> getallperson() {

        SQLiteDatabase database = this.getReadableDatabase();
        List<Person> data = new ArrayList<>();
        String query = "SELECT * FROM person";
        Cursor cursor = database.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Person person = new Person();
                person.setId(cursor.getInt(cursor.getColumnIndex(info_db.DATA_ID)));
                person.setCategory(cursor.getString(cursor.getColumnIndex(info_db.DATA_CATEGORY)));
                person.setName(cursor.getString(cursor.getColumnIndex(info_db.DATA_NAME)));
                person.setField(cursor.getString(cursor.getColumnIndex(info_db.DATA_FIELD)));
                person.setDisc(cursor.getString(cursor.getColumnIndex(info_db.DATA_DISK)));
                person.setImage(cursor.getString(cursor.getColumnIndex(info_db.DATA_IMAGE)));
                person.setFav(cursor.getInt(cursor.getColumnIndex(info_db.DATA_FAV)));
                data.add(person);
            } while (cursor.moveToNext());
            {
                cursor.close();
                database.close();
            }
        }
        return data;

    }

    public List<Person> getalliraniperson() {

        SQLiteDatabase database = this.getReadableDatabase();
        List<Person> data = new ArrayList<>();
        String query = "SELECT * FROM person WHERE category='irani'";
        Cursor cursor = database.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Person person = new Person();
                person.setId(cursor.getInt(cursor.getColumnIndex(info_db.DATA_ID)));
                person.setCategory(cursor.getString(cursor.getColumnIndex(info_db.DATA_CATEGORY)));
                person.setName(cursor.getString(cursor.getColumnIndex(info_db.DATA_NAME)));
                person.setField(cursor.getString(cursor.getColumnIndex(info_db.DATA_FIELD)));
                person.setDisc(cursor.getString(cursor.getColumnIndex(info_db.DATA_DISK)));
                person.setImage(cursor.getString(cursor.getColumnIndex(info_db.DATA_IMAGE)));
                person.setFav(cursor.getInt(cursor.getColumnIndex(info_db.DATA_FAV)));
                data.add(person);
            } while (cursor.moveToNext());
            {
                cursor.close();
                database.close();
            }
        }
        return data;

    }

    public List<Person> getallforginperson() {

        SQLiteDatabase database = this.getReadableDatabase();
        List<Person> data = new ArrayList<>();
        String query = "SELECT * FROM person WHERE category='foreign'";
        Cursor cursor = database.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Person person = new Person();
                person.setId(cursor.getInt(cursor.getColumnIndex(info_db.DATA_ID)));
                person.setCategory(cursor.getString(cursor.getColumnIndex(info_db.DATA_CATEGORY)));
                person.setName(cursor.getString(cursor.getColumnIndex(info_db.DATA_NAME)));
                person.setField(cursor.getString(cursor.getColumnIndex(info_db.DATA_FIELD)));
                person.setDisc(cursor.getString(cursor.getColumnIndex(info_db.DATA_DISK)));
                person.setImage(cursor.getString(cursor.getColumnIndex(info_db.DATA_IMAGE)));
                person.setFav(cursor.getInt(cursor.getColumnIndex(info_db.DATA_FAV)));
                data.add(person);
            } while (cursor.moveToNext());
            {
                cursor.close();
                database.close();
            }
        }
        return data;

    }

    public List<Person> getallfavperson() {

        SQLiteDatabase database = this.getReadableDatabase();
        List<Person> data = new ArrayList<>();
        String query = "SELECT * FROM person WHERE fav=1";
        Cursor cursor = database.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Person person = new Person();
                person.setId(cursor.getInt(cursor.getColumnIndex(info_db.DATA_ID)));
                person.setCategory(cursor.getString(cursor.getColumnIndex(info_db.DATA_CATEGORY)));
                person.setName(cursor.getString(cursor.getColumnIndex(info_db.DATA_NAME)));
                person.setField(cursor.getString(cursor.getColumnIndex(info_db.DATA_FIELD)));
                person.setDisc(cursor.getString(cursor.getColumnIndex(info_db.DATA_DISK)));
                person.setImage(cursor.getString(cursor.getColumnIndex(info_db.DATA_IMAGE)));
                person.setFav(cursor.getInt(cursor.getColumnIndex(info_db.DATA_FAV)));
                data.add(person);
            } while (cursor.moveToNext());
            {
                cursor.close();
                database.close();
            }
        }
        return data;

    }


    public int fav_value(int id) {

        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT " + info_db.DATA_FAV + " FROM person WHERE " + info_db.DATA_ID + "=" + id + "";
        int value = 0;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            value = cursor.getInt(cursor.getColumnIndex(info_db.DATA_FAV));
            do {

            } while (cursor.moveToNext());
        }
        db.close();
        return value;
    }

    public void fav(int status, int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "UPDATE person SET " + info_db.DATA_FAV + "=" + status + " WHERE " + info_db.DATA_ID + "=" + id + "";
        db.execSQL(query);
        db.close();
    }
}
