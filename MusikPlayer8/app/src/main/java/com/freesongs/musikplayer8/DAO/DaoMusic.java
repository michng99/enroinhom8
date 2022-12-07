package com.freesongs.musikplayer8.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.freesongs.musikplayer8.Data.Dataaa;
import com.freesongs.musikplayer8.Model.Songs;

import java.util.ArrayList;

public class DaoMusic {

    Dataaa dataaa;
    public DaoMusic (Context context){
        dataaa = new Dataaa(context);
    }

    public ArrayList<Songs> getDSbaihat(){
        ArrayList<Songs> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dataaa.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM BAIHAT",null);
        if (cursor.getCount() != 0){
            cursor.moveToFirst();

            do{
                list.add(new Songs( cursor.getString(0) , cursor.getString(1) ));
            } while (cursor.moveToNext());
        }
        return list;

    }

}
