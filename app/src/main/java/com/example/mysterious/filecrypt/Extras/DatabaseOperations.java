package com.example.mysterious.filecrypt.Extras;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jaykay12 on 5/2/17.
 */
public class DatabaseOperations extends SQLiteOpenHelper {

    SQLiteDatabase db;
    static String dbname="hackathon";

    public DatabaseOperations(Context context) {
        super(context, dbname, null, 1);

//------------------------------------Database Opening/ (Database Creation and Table Creations)--------------
        db = context.openOrCreateDatabase(dbname,SQLiteDatabase.CREATE_IF_NECESSARY,null);
        String tbl="create table if not exists notes ( noteid int primary key, notetitle text, notecontent text)";
        db.execSQL(tbl);


//-----------------------------------------------------------------------------------------------------------
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public long AddNotes(String noteid, String notetitle, String notecontent)
    {
        db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("noteid",noteid);
        cv.put("notetitle",notetitle);
        cv.put("notecontent",notecontent);

        long result = db.insert("notes",null,cv);
        return result;
    }

    public Cursor ReadAll()
    {
        db = this.getReadableDatabase();

        String qry = "select noteid,notetitle,notecontent from notes";
        Cursor cr = db.rawQuery(qry, null);
        return cr;
    }

}