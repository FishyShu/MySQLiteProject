package com.example.mysqliteproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class YudBatMapActivity extends AppCompatActivity {


    LayoutInflater inflater;
    SQLiteDatabase database;
    ArrayList<Room_Information> room_list;

    Button btn_room_602, btn_room_603, btn_staff_room, btn_room_606,
            btn_room_601, btn_room_605, btn_room_604, btn_room_608;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yud_bat_map);

        // Open the Rooms database.
        database = openOrCreateDatabase(Sqlite_Utils.DATABASE_NAME, Context.MODE_PRIVATE, null);
        room_list = Sqlite_Utils.retrieveRoomList(database);

        //Layout inflater
        inflater = getLayoutInflater();

        // find view by id for all the buttons :D
        implementRoomButton();


        // get the id of the button that was pressed
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int buttonId = view.getId();

                check(buttonId);


            }
        };
        btn_staff_room.setOnClickListener(listener);
        btn_room_601.setOnClickListener(listener);
        btn_room_602.setOnClickListener(listener);
        btn_room_603.setOnClickListener(listener);
        btn_room_604.setOnClickListener(listener);
        btn_room_605.setOnClickListener(listener);
        btn_room_606.setOnClickListener(listener);
        btn_room_608.setOnClickListener(listener);


    }
    // what button was pressed, method --> customAlertSetter |
    private void check(int buttonId) {

        switch (buttonId){
            case (R.id.btn_room_601):
                customAlertSetter(0);
                break;
            case (R.id.btn_room_602):
                customAlertSetter(1);
                break;
            case (R.id.btn_room_603):
                customAlertSetter(2);
                break;
            case (R.id.btn_room_604):
                customAlertSetter(3);
                break;
            case (R.id.btn_room_605):
                customAlertSetter(4);
                break;
            case (R.id.btn_room_606):
                customAlertSetter(5);
                break;
            case (R.id.btn_room_608):
                customAlertSetter(6);
                break;
            default:
                customAlertAdmin(); // Will allow the use to clean the SQLite, for now...
                break;
        }

    }

    private void customAlertAdmin() {

        //Have a custom Alert that could delete all the SQLite data by pressing a button.
        //Layout is called activity_sqlite_clean

        View alertLayout = inflater.inflate(R.layout.activity_sqlite_admin_clean, null);
        AlertDialog.Builder alert = new AlertDialog.Builder(this).setView(alertLayout);

        Button btn_clean = alertLayout.findViewById(R.id.btn_clean);
        btn_clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Clean all the data.
                // Show toast that the action was successful and exit out of the application automatically


                List<String> tables = new ArrayList<>();
                tables.add(Sqlite_Utils.TABLE_BUILDINGS_NAME);
                tables.add(Sqlite_Utils.TABLE_ROOM_NAME);


                // Thanks random guy from the internet :L
                for (String table : tables) {
                    try {
                        database.execSQL("DROP TABLE IF EXISTS " + table);
                    } catch (SQLiteException e) {
                        Log.e("SQLiteException", "Error dropping table: " + e.getMessage());
                    }
                }
                //restarts the application :) ( IT WORKED :D )
                Intent i = new Intent(YudBatMapActivity.this, SplashScreen.class);
                finish();
                startActivity(i);

            }
        });

        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(YudBatMapActivity.this, "OK", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();

    }

    // Sets the custom alert.
    private void customAlertSetter(int i) {

        View alertLayout = inflater.inflate(R.layout.activity_info_screen, null);

        TextView tv_room_id = alertLayout.findViewById(R.id.tv_room_id);
        TextView tv_name = alertLayout.findViewById(R.id.tv_name);
        TextView tv_type = alertLayout.findViewById(R.id.tv_type);
        TextView tv_description = alertLayout.findViewById(R.id.tv_description);
        TextView tv_room_building_id = alertLayout.findViewById(R.id.tv_room_building_id);

        tv_room_id.setText(room_list.get(i).getId());
        tv_name.setText(room_list.get(i).getName());
        tv_type.setText(room_list.get(i).getType());
        tv_description.setText(room_list.get(i).getDescription());
        tv_room_building_id.setText(room_list.get(i).getBuilding_id());

        AlertDialog.Builder alert = new AlertDialog.Builder(this).setView(alertLayout);
        //alert.setView(alertLayout);
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(YudBatMapActivity.this, "OK", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = alert.create();

        dialog.show();

    }

    private void implementRoomButton() {

        btn_staff_room = findViewById(R.id.btn_staff_room);
        btn_room_601 = findViewById(R.id.btn_room_601);
        btn_room_602 = findViewById(R.id.btn_room_602);
        btn_room_603 = findViewById(R.id.btn_room_603);
        btn_room_604 = findViewById(R.id.btn_room_604);
        btn_room_605 = findViewById(R.id.btn_room_605);
        btn_room_606 = findViewById(R.id.btn_room_606);
        btn_room_608 = findViewById(R.id.btn_room_608);

    }
}

// old code from testing
/*

    ImageView iv_test;
    Button btn_test;
    ArrayList<Class_Information> class_list;
    SQLiteDatabase database;
    RoomAdapter adapter;

    //TextView tv_name, tv_type, tv_tv_label, tv_description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        database = openOrCreateDatabase(SQLite_Utils.DATABASE_NAME, Context.MODE_PRIVATE, null);
        class_list = SQLite_Utils.retrieveList(database);

        iv_test = findViewById(R.id.iv_test);
        btn_test = findViewById(R.id.btn_test);

        LayoutInflater inflater = getLayoutInflater();

        View alertLayout = inflater.inflate(R.layout.activity_info_screen, null);

        TextView tv_name = alertLayout.findViewById(R.id.tv_name);
        TextView tv_type = alertLayout.findViewById(R.id.tv_type);
        TextView tv_tv_label = alertLayout.findViewById(R.id.tv_label);
        TextView tv_description = alertLayout.findViewById(R.id.tv_description);

// Set the values for the views
        tv_name.setText(class_list.get(0).getName());
        tv_type.setText(class_list.get(0).getType());
        tv_tv_label.setText(class_list.get(0).getLabel());
        tv_description.setText(class_list.get(0).getDescription());

        AlertDialog.Builder alert = new AlertDialog.Builder(this).setView(alertLayout);
        alert.setView(alertLayout);
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //
                Toast.makeText(Map_Activity.this, "OK", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog = alert.create();

        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });

    }
}
 */