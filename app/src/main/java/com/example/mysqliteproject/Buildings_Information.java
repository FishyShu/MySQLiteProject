package com.example.mysqliteproject;

public class Buildings_Information {

    private String id;
    private String name;
    private String floor;

    public Buildings_Information(String id, String name, String floor) {
        this.id = id;
        this.name = name;
        this.floor = floor;
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

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }
}


/* static final String TABLE_BUILDINGS_NAME = "tbl_building";
    static final String COL_BUILDINGS_ID = "-1";
    static final String COL_BUILDINGS_NAME = "name";
    static final String COL_BUILDINGS_FLOOR = String.valueOf('1'); // 0 --> Only has One floor, 1 --> has Two floors.
    // ===

 */
