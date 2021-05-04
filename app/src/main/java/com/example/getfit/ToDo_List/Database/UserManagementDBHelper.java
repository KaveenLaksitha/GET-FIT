package com.example.getfit.ToDo_List.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class UserManagementDBHelper extends SQLiteOpenHelper {

    private Context context;

    private static final String DATABASE_NAME = "GETFIT.db";
    private static final int DATABASE_VERSION = 1;

    //To do list data base
    private static final String TABLE_NAME = "TodoList";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TITLE = "list_name";
    private static final String COLUMN_DESCRIPTION = "list_description";

    //Sign Up page data base
    private static final String TABLE_NAME_USER = "User";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_GENDER = "gender";
    private static final String COLUMN_HEIGHT = "height";
    private static final String COLUMN_WEIGHT = "weight";
    private static final String COLUMN_AGE = "age";


    //create a helper object to create, open, and/or manage a database
    public UserManagementDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //To do list data base
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_TITLE + " TEXT," +
                COLUMN_DESCRIPTION + " TEXT);";
        db.execSQL(query);

        String USER_QUERY = " CREATE TABLE " + TABLE_NAME_USER +
                " (" + COLUMN_USERNAME + " TEXT PRIMARY KEY," +
                COLUMN_EMAIL + " TEXT," +
                COLUMN_PASSWORD + " TEXT," +
                COLUMN_GENDER + " TEXT," +
                COLUMN_HEIGHT + " FLOAT," +
                COLUMN_WEIGHT + " FLOAT," +
                COLUMN_AGE + " INTEGER);";

         db.execSQL(USER_QUERY);

    }

    //upgrading the data base when we make changes to the schema
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_USER);
        onCreate(db);

    }

    //To do list insert to the data base
    public void addlist(String title, String description) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_TITLE, title);
        values.put(COLUMN_DESCRIPTION, description);
        long result = db.insert(TABLE_NAME, null, values);

        if(result ==  -1){
            Toast.makeText(context, "Failed to added", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "List Added successfully", Toast.LENGTH_SHORT).show();
        }

    }


    public boolean insertData(String username, String email, String password, String gender, float height,float weight, int age){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_USERNAME,username);
        values.put(COLUMN_EMAIL,email);
        values.put(COLUMN_PASSWORD,password);
        values.put(COLUMN_GENDER,gender);
        values.put(COLUMN_HEIGHT,height);
        values.put(COLUMN_WEIGHT,weight);
        values.put(COLUMN_AGE,age);

        long result = db.insert(TABLE_NAME_USER,null,values);

        if(result == -1){
            return false;
        }else{
            return true;
        }

    }

public boolean checkusername(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(" Select * from " + TABLE_NAME_USER + " where " + COLUMN_USERNAME + " = ? " , new String[] {username});
        if(cursor.getCount()>0)
            return  true;
        else
            return false;
}

public Boolean checkpassword(String username,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(" Select * from " + TABLE_NAME_USER + " where " + COLUMN_USERNAME + " =  ?  AND " +COLUMN_PASSWORD + " = ? ", new String[] {username,password});
    if(cursor.getCount()>0)
        return  true;
    else
        return false;
    }



    //fetch data from the result sets of the queries. You can create Cursor object using the cursor() method of the Connection object/class.

    //To do list retrieve as list method
     public Cursor readAllData() {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    //To do list update in data base method
    public void updateData(String row_id, String title, String description){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, title);
        values.put(COLUMN_DESCRIPTION, description);


        long result = db.update(TABLE_NAME, values, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }

    }

    //To do list delete one row from data base
    public void deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
        }
    }

    //To do list delete all data from data base
    public void deleteAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
    }

}


