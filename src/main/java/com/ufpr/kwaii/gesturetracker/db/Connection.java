package com.ufpr.kwaii.gesturetracker.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Connection  extends SQLiteOpenHelper {

    private static final String DB_NAME = "database.db";
    private static final String TABLE = "gestures";
    private static final String ID = "_id";
    private static final String TYPE = "type";
    private static final String INITIAL_POINT = "inicial_point";
    private static final String FINAL_POINT = "final_point";
    private static final String  PRESSURE = "pressure";
    private static final int VERSION = 1;

    public Connection(Context context){
        super(context, DB_NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE + "("
                + ID + "integer primary key autoincrement,"
                + TYPE + "text, "
                + INITIAL_POINT + "float, "
                + FINAL_POINT + "float,"
                + PRESSURE + "float"
                + ")";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);
    }

    public static String getTABLE() {
        return TABLE;
    }

    public static String getTYPE() {
        return TYPE;
    }

    public static String getInitialPoint() {
        return INITIAL_POINT;
    }

    public static String getFinalPoint() {
        return FINAL_POINT;
    }

    public static String getPRESSURE() {
        return PRESSURE;
    }
}
