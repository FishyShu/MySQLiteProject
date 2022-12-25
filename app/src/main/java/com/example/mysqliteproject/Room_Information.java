package com.example.mysqliteproject;

public class Room_Information {

    private String id;
    private String name;
    private String type;
    private String description;
    private String building_id; // Get the building's id and make it the building id :)


    public Room_Information(String id, String name, String type, String description, String building_id) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.building_id = building_id;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBuilding_id() {
        return building_id;
    }

    public void setBuilding_id(String building_id) {
        this.building_id = building_id;
    }
}


/*
 // Table for Rooms
    static final String TABLE_ROOM_NAME = "tbl_room";
    static final String COL_ROOM_ID = String.valueOf("-1");
    static final String COL_ROOM_NAME = "name";
    static final String COL_ROOM_TYPE = "type";
    static final String COL_ROOM_DESCRIPTION = "description";
    // ===

 */
