package com.example.trainticketsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Passengers.db";
    public static final String TABLE_NAME = "Passengers_table";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_FROMTO = "FROM_TO";
    public static final String COLUMN_DATE = "DATE";
    public static final String COLUMN_TIME = "TIME";
    public static final String COLUMN_PASSENGERNUMBER = "NUMBER_OF_PASSENGERS";
    public static final String COLUMN_TICKETNUMBER = "TICKET_NUMBER";

    Context context;
    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_FROMTO + " TEXT, " + COLUMN_DATE + " DATE, " +  COLUMN_TIME + " TIME, "
                + COLUMN_PASSENGERNUMBER + " INTEGER, " + COLUMN_TICKETNUMBER + " INTEGER );";
        db.execSQL(SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL_DELETE = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(SQL_DELETE);
        onCreate(db);
    }
    public void insertData(String fromTo, String date, String time, int passengersNumber,int ticketNumber){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_FROMTO,fromTo);
        values.put(COLUMN_DATE,date);
        values.put(COLUMN_TIME,time);
        values.put(COLUMN_PASSENGERNUMBER,passengersNumber);
        values.put(COLUMN_TICKETNUMBER,ticketNumber);

        long result = db.insert(TABLE_NAME,null, values);
        if (result == -1)
            Toast.makeText(context, "Data not saved", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(context, "Data saved successfully", Toast.LENGTH_LONG).show();
    }
    public Cursor readData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        return cursor;
    }
}
