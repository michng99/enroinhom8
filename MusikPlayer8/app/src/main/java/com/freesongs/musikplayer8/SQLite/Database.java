package com.freesongs.musikplayer8.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    public Database(Context context){
        super(context , "DULIEU" , null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String user = "Create table USER(id integer primary key autoincrement , username text not null , password text not null)";
        sqLiteDatabase.execSQL(user);

        

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
