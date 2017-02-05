package com.example.mysterious.filecrypt.Extras;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

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
        String tbl="create table if not exists notes ( noteid integer primary key autoincrement, notetitle text, notecontent text, notecreated DATETIME DEFAULT CURRENT_TIMESTAMP)";
        db.execSQL(tbl);


//-----------------------------------------------------------------------------------------------------------
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public long AddNotes(String notetitle, String notecontent)
    {
        db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        //cv.put("noteid",noteid);
        cv.put("notetitle",notetitle);
        cv.put("notecontent",notecontent);

        long result = db.insert("notes",null,cv);
        return result;
    }

    public Cursor ReadAll()
    {
        db = this.getReadableDatabase();

        String qry = "select noteid,notetitle,notecontent,notecreated from notes";
        Cursor cr = db.rawQuery(qry, null);
        return cr;
    }

    public ArrayList ReadNote(Integer noteid)
    {
        ArrayList info = new ArrayList();
        db = this.getReadableDatabase();

        String qry = "select * from notes where noteid="+noteid;
        Cursor cr = db.rawQuery(qry, null);
        cr.moveToFirst();
            info.add(cr.getString(0));
            info.add(cr.getString(1));
            info.add(cr.getString(2));
            info.add(cr.getString(3));

        return info;
    }

}