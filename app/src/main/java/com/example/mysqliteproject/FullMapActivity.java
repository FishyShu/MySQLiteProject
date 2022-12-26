package com.example.mysqliteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class FullMapActivity extends AppCompatActivity implements View.OnClickListener {

    SQLiteDatabase database;

    ArrayList<Buildings_Information> buildings_informationList;
    Button btn_yud_bat;
    Button btn_error0, btn_error1, btn_error2, btn_error3, btn_error4, btn_error5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_map);

        //add the images, and invisible buttons.

        btn_yud_bat = findViewById(R.id.btn_yud_bat);

        btn_error0 = findViewById(R.id.btn_error0);
        btn_error1 = findViewById(R.id.btn_error1);
        btn_error2 = findViewById(R.id.btn_error2);
        btn_error3 = findViewById(R.id.btn_error3);
        btn_error4 = findViewById(R.id.btn_error4);
        btn_error5 = findViewById(R.id.btn_error5);


        database = openOrCreateDatabase(Sqlite_Utils.DATABASE_NAME,
                Context.MODE_PRIVATE,
                null);

        buildings_informationList = Sqlite_Utils.retrieveBuildingList(database);


        //On click, will show the name of the build
        btn_yud_bat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FullMapActivity.this, ""+
                        buildings_informationList.get(0).getName()
                        , Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(FullMapActivity.this,
                        YudBatMapActivity.class);
                startActivity(intent);
            }
        });


        btn_error0.setOnClickListener(this);
        btn_error1.setOnClickListener(this);
        btn_error2.setOnClickListener(this);
        btn_error3.setOnClickListener(this);
        btn_error4.setOnClickListener(this);
        btn_error5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "ERROR, Building Connection...",
                Toast.LENGTH_SHORT).show();
    }
}