package com.example.mysqliteproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Sqlite_Utils {

    static final String DATABASE_NAME = "db_school_information";
    // ===
    // Table for the buildings
    static final String TABLE_BUILDINGS_NAME = "tbl_building";
    static final String COL_BUILDINGS_ID = "buildings_id";
    static final String COL_BUILDINGS_NAME = "name";
    static final String COL_BUILDINGS_FLOOR = "buildings_floor";
    // ===
    // Table for Rooms
    static final String TABLE_ROOM_NAME = "tbl_room";
    static final String COL_ROOM_ID = "room_id";
    static final String COL_ROOM_NAME = "name";
    static final String COL_ROOM_TYPE = "type";
    static final String COL_ROOM_DESCRIPTION = "description";
    static final String COL_ROOM_BUILDING_ID = "room_building_id";
    // ===

    // Create The Tables If they not Exists, Tbl_-Buildings, Room
    public static void createTables(@NonNull SQLiteDatabase db) {

                                    //Buildings
                                    //VV
        db.execSQL("Create Table If Not Exists " + TABLE_BUILDINGS_NAME +
                "(" + COL_BUILDINGS_ID + " INTEGER PRIMARY KEY," + // the building's id
                COL_BUILDINGS_NAME + " Text," +
                COL_BUILDINGS_FLOOR + " Text);");

                                    //Rooms
                                    //VV
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_ROOM_NAME +
                "(" + COL_ROOM_ID + " INTEGER PRIMARY KEY," +
                COL_ROOM_NAME + " TEXT, " +
                COL_ROOM_TYPE + " TEXT, " +
                COL_ROOM_DESCRIPTION + " TEXT," +
                COL_ROOM_BUILDING_ID + " TEXT);");


    }


    // fix :)
    // vv
    public static void insertToTables(SQLiteDatabase db) {
        //lets do the buildings first, even though we're going to add Only YudBat.
        ArrayList<Buildings_Information> buildingList = buildBuildingsList();
        for (Buildings_Information cp : buildingList) {
            db.execSQL("Insert Or Ignore Into  " + TABLE_BUILDINGS_NAME +
                    " Values('" +
                    cp.getId() +
                    "','" +
                    cp.getName() +
                    "','" +
                    cp.getFloor() +
                    "');");
        }

        ArrayList<Room_Information> roomList = buildRoomsList();
        for (Room_Information cp : roomList) {
            db.execSQL("Insert Or Ignore Into " + TABLE_ROOM_NAME +
                    " Values('" +
                    cp.getId() +
                    "','" +
                    cp.getName() +
                    "','" +
                    cp.getType() +
                    "','" +
                    cp.getDescription() +
                    "','" +
                    cp.getBuilding_id() +
                    "');");
        }

    }

    @NonNull
    public static ArrayList<Buildings_Information> retrieveBuildingList(SQLiteDatabase db) {
        ArrayList<Buildings_Information> list = new ArrayList<>();
        Cursor c = db.rawQuery("Select * From " + TABLE_BUILDINGS_NAME + "", null);
        if (c.getCount() != 0) {
            while (c.moveToNext()) {
                list.add(new Buildings_Information(c.getString(0), c.getString(1), c.getString(2)));
            }
        }
        return list;
    }
    public static ArrayList<Room_Information> retrieveRoomList(SQLiteDatabase db) {
        ArrayList<Room_Information> list = new ArrayList<>();
        Cursor c = db.rawQuery("Select * From " + TABLE_ROOM_NAME + "", null);
        if (c.getCount() != 0) {
            while (c.moveToNext()) {
                list.add(new Room_Information(c.getString(0), c.getString(1), c.getString(2), c.getString(3), c.getInt(4)));
            }
        }
        return list;
    }


    // change it so the list won't just get added, it'll check if the id has already been inserted!
    private static ArrayList<Buildings_Information> buildBuildingsList() {
        ArrayList<Buildings_Information> list = new ArrayList<Buildings_Information>();

        Buildings_Information b1 = new Buildings_Information("600", "Yud bat", "1");

        list.add(b1);
        return list;
    }
    private static ArrayList<Room_Information> buildRoomsList() {
        ArrayList<Room_Information> list = new ArrayList<Room_Information>();

        final int ROOM_COUNT = 7;
        /* I made the Building id = -1. */

        //601
        Room_Information r1 = new Room_Information("601", "YudBatOne", "ClassRoom",
                "Save the description in an xml :)",-1);

        //602
        Room_Information r2 = new Room_Information("602", "YudBatTwo", "ClassRoom",
                "Save the description in an xml :)",-1);

        //603
        Room_Information r3 = new Room_Information("603", "YudBatThree", "ClassRoom",
                "Save the description in an xml :)",-1);

        //604
        Room_Information r4 = new Room_Information("604", "YudBatFour", "ClassRoom",
                "Save the description in an xml :)",-1);

        //605
        Room_Information r5 = new Room_Information("605", "YudBatFive", "ClassRoom",
                "Save the description in an xml :)",-1);

        //606
        Room_Information r6 = new Room_Information("606", "YudBatSix", "ClassRoom",
                "Save the description in an xml :)",-1);

        //608
        Room_Information r7 = new Room_Information("608", "YudBatEight", "ClassRoom",
                "Save the description in an xml :)",-1);





        list.add(r1);
        list.add(r2);
        list.add(r3);
        list.add(r4);
        list.add(r5);
        list.add(r6);
        list.add(r7);
        return list;
    }

}
