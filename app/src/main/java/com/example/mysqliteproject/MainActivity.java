package com.example.mysqliteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;

    Button btn_start;
    TextView tv_title0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = openOrCreateDatabase(Sqlite_Utils.DATABASE_NAME,
                Context.MODE_PRIVATE, null);

        tv_title0 = findViewById(R.id.tv_title0);
        //draw(tv_title0);


        btn_start = findViewById(R.id.btn_start);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this,
                        FullMapActivity.class);

                startActivity(i);
            }
        });



    }
        // make the outline of tv_title0 hard
    // private void draw(TextView tv_title0){};
}