package com.example.mysqliteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        // Opens or Creates the database
        db = openOrCreateDatabase(Sqlite_Utils.DATABASE_NAME, Context.MODE_PRIVATE, null);

        // Creates the tables, if they don't already exist.
        Sqlite_Utils.createTables(db);

        // inserts the data to the tables if unless the id already exists.
        Sqlite_Utils.insertToTables(db);

        //Sets the buildings' id in the rooms table :D
        Sqlite_Utils.insertToRoomsBuildingsId(db);

        //bla bla, delay bla bla
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                // .this --> MainActivity.class
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);

                // finishes .this
                finish(); //--> causes a crash when I used recreate();
            }
            //Delays for 5.000 Seconds
        }, 5000);

    }
}