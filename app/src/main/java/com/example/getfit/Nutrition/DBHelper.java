package com.example.getfit.Nutrition;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "GETFIT.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME_MACRO = "MacroDetails";

    public static final String queryToMacro = "CREATE TABLE " + TABLE_NAME_MACRO +
            " (" + "Id" + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "foodName" + " DECIMAL(5,2)," +
            "energy" + " DECIMAL(5,2)," +
            "fat" + " DECIMAL(5,2)," +
            "carb" + " DECIMAL(5,2)," +
            "fiber" + " DECIMAL(5,2)," +
            "protein" + " DECIMAL(5,2)," +
            "sodium" + " DECIMAL(5,2)," +
            "cholesterol" + " DECIMAL(5,2)," +
            "potasium" + " DECIMAL(5,2)," +
            "calories" + " DECIMAL(5,2));";



    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(queryToMacro);

    }


    void addMacro(String foodName, String energy, String fat, String carb, String fiber, String protein, String sodium, String cholesterol, String potasium, String calories){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("foodName", foodName);
        cv.put("energy", energy);
        cv.put("fat", fat);
        cv.put("carb", carb);
        cv.put("fiber", fiber);
        cv.put("protein", protein);
        cv.put("sodium", sodium);
        cv.put("cholesterol", cholesterol);
        cv.put("potasium", potasium);
        cv.put("calories", calories);


        long result = db.insert("macroDetails",null,cv);
        if(result == -1){
            Toast.makeText(context, "data insertion failed", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "added successfully", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readMacroTableData(){
        String query = "SELECT * FROM " + TABLE_NAME_MACRO;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_MACRO);
        onCreate(db);
    }

}
