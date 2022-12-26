package com.example.mysqliteproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

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

        ArrayList<Room_Information> roomList = buildRoomsList(db);
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
                list.add(new Room_Information(c.getString(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4)));
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
    private static ArrayList<Room_Information> buildRoomsList(SQLiteDatabase db) {
        ArrayList<Room_Information> list = new ArrayList<Room_Information>();


        // Yud Bat would be -1, YudAlaf would be a different number, etc...



        //601
        Room_Information r1 = new Room_Information("601", "YudBatOne", "ClassRoom",
                getDescription(1), "-1");

        //602
        Room_Information r2 = new Room_Information("602", "YudBatTwo", "ClassRoom",
                getDescription(2),"-1");

        //603
        Room_Information r3 = new Room_Information("603", "YudBatThree", "ClassRoom",
                getDescription(3),"-1");

        //604
        Room_Information r4 = new Room_Information("604", "YudBatFour", "ClassRoom",
                getDescription(4),"-1");

        //605
        Room_Information r5 = new Room_Information("605", "YudBatFive", "ClassRoom",
                getDescription(5),"-1");

        //606
        Room_Information r6 = new Room_Information("606", "YudBatSix", "ClassRoom",
                getDescription(6),"-1");

        //608
        Room_Information r7 = new Room_Information("608", "YudBatEight", "ClassRoom",
                getDescription(7),"-1");





        list.add(r1);
        list.add(r2);
        list.add(r3);
        list.add(r4);
        list.add(r5);
        list.add(r6);
        list.add(r7);
        return list;
    }

    private static String getDescription(int i) {
        switch(i){
            case 1:
                return "Classroom 601 is a spacious and well-lit classroom located on the ground " +
                        "floor of the building. It can comfortably accommodate up to 30 students " +
                        "at a time and is equipped with modern teaching aids such as a whiteboard," +
                        " projector, and interactive displays. The room has a flexible seating " +
                        "arrangement, with tables and chairs that can be rearranged to suit the " +
                        "needs of the class. The walls are adorned with colorful posters and charts," +
                        " creating a cheerful and engaging learning environment. Overall, Classroom" +
                        " 601 is a welcoming and well-equipped space that is ideal for collaborative" +
                        " learning and small group discussions.";
            case 2:
                return "Classroom 602 is a medium-sized classroom located on the ground floor of" +
                        " the building. It can accommodate up to 25 students and is equipped with" +
                        " the latest teaching technologies, including a whiteboard, projector, and" +
                        " interactive displays. The room has a modern and functional design, with" +
                        " comfortable seating and ample natural light. The walls are adorned with" +
                        " educational posters and charts, creating a lively and stimulating learning" +
                        " environment. Overall, Classroom 602 is a well-equipped and welcoming" +
                        " space that is ideal for collaborative learning and small group discussions.";

            case 3:
                return "Classroom 603 is a bright and welcoming classroom located on the ground" +
                        " floor of the building. It has a capacity of 35 students and is equipped" +
                        " with state-of-the-art teaching aids such as a whiteboard, projector, and" +
                        " interactive displays. The room has a modern and comfortable seating" +
                        " arrangement, with tables and chairs arranged in a semi-circle. The walls" +
                        " are adorned with inspiring quotes and educational posters, creating a" +
                        " stimulating and inspiring learning environment. Overall, Classroom 603 is" +
                        " a spacious and well-equipped space that is ideal for collaborative " +
                        "learning and small group discussions.";

            case 4:
                return "Classroom 604 is a medium-sized classroom located on the same floor as" +
                        " Classroom 601. It has a capacity of around 40 students and is equipped" +
                        " with a range of teaching aids, including a whiteboard, projector, and" +
                        " interactive displays. The room has large windows that allow plenty of" +
                        " natural light to enter, creating a bright and welcoming atmosphere." +
                        " The seating arrangement is flexible, with tables and chairs that can" +
                        " be rearranged to suit the needs of the class. The walls are decorated" +
                        " with a variety of educational posters and charts, providing a stimulating" +
                        " learning environment. Overall, Classroom 604 is a well-equipped" +
                        " and comfortable space that is ideal for both individual and group work.";

            case 5:
                return "Classroom 605 is a spacious and well-equipped classroom located on the same" +
                        " floor as the other classrooms in the building. It has a capacity of around" +
                        " 50 students and is equipped with all the necessary teaching aids, including" +
                        " a whiteboard, projector, and interactive displays. The room has large" +
                        " windows that let in plenty of natural light, creating a bright and welcoming" +
                        " atmosphere. The seating arrangement is flexible, with tables and chairs" +
                        " that can be rearranged to suit the needs of the class. The walls are" +
                        " adorned with a variety of educational posters and charts, providing a" +
                        " stimulating learning environment. This particular classroom is a favorite" +
                        " among students and teachers alike, thanks to its comfortable and welcoming atmosphere.";

            case 6:
                return "Classroom 606 is a unique and innovative space located on the same floor as" +
                        " the other classrooms in the building. It has a capacity of around 40" +
                        " students and is designed to facilitate collaborative and experiential" +
                        " learning. The room is equipped with a range of modern teaching aids," +
                        " including a whiteboard, projector, and interactive displays." +
                        " It also has a variety of flexible furniture, such as standing desks and" +
                        " beanbag chairs, to accommodate different learning styles. The walls are" +
                        " adorned with educational posters and charts, as well as a giant whiteboard" +
                        " for brainstorming and problem-solving. Overall, Classroom 606 is a" +
                        " dynamic and creative space that encourages students to think outside the" +
                        " box and embrace new ideas.";

            case 7:
                return "Classroom 608 is a cozy and inviting space located on the same floor as" +
                        " the other classrooms in the building. It has a capacity of around 30 " +
                        "students and is decorated with a range of cultural artifacts and decor," +
                        " creating a unique and welcoming atmosphere. The room is equipped with " +
                        "all the necessary teaching aids, including a whiteboard, projector, and" +
                        " interactive displays. The seating arrangement is flexible, with tables " +
                        "and chairs that can be rearranged to suit the needs of the class. The walls" +
                        " are adorned with educational posters and charts, as well as a variety of" +
                        " traditional artwork and decorative items. Overall, Classroom 608 is a warm" +
                        " and welcoming space that fosters a sense of community and cultural exchange.";

            default:
                return "ERROR";

        }

    }


    public static void insertToRoomsBuildingsId(SQLiteDatabase db){

        // retrieves  buildings_id and inserts it into tbl_building table
        Cursor cursor = db.rawQuery("Select "+COL_BUILDINGS_ID+" From "+TABLE_BUILDINGS_NAME, null);
        //learn what .moveToFirst(); does.
        cursor.moveToFirst();
        String buildingId = cursor.getString(0);
        cursor.close();

        // :DDDD
        db.execSQL("Update "+TABLE_ROOM_NAME+" Set "+COL_ROOM_BUILDING_ID+" = '" + buildingId + "' Where "+COL_ROOM_BUILDING_ID+" = '-1'");
    }
}
