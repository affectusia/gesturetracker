package com.ufpr.kwaii.gesturetracker.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Controller {

    private SQLiteDatabase db;
    private Connection base;

    public Controller(Context context){
        base = new Connection(context);
    }

    public String insertGestures(String type, float intial_point, float final_point, float pressure) {
        ContentValues values;
        long result;

        db = base.getWritableDatabase();
        values = new ContentValues();
        values.put(Connection.getTYPE(), type);
        values.put(Connection.getInitialPoint(), intial_point);
        values.put(Connection.getFinalPoint(), final_point);
        values.put(Connection.getPRESSURE(), pressure);


        result = db.insert(Connection.getTABLE(), null, values);
        db.close();

        if (result == -1)
            return "ERROR: INSERT DATA";
        else
            return "OK: INSERT DATA";

    }
}
