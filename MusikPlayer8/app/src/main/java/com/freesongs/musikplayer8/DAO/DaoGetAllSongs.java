package com.freesongs.musikplayer8.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.freesongs.musikplayer8.Data.Dataaa;
import com.freesongs.musikplayer8.model.Songs;

import java.util.ArrayList;

public class DaoGetAllSongs {

    Dataaa dataaa;

    public DaoGetAllSongs(Context context) {
        dataaa = new Dataaa(context);
    }

    public ArrayList<Songs> getall() {
        ArrayList<Songs> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dataaa.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM BAIHAT", null);
        if (cursor.getCount() != 0) {
            cursor.moveToFirst();
            do {
                list.add(new Songs(cursor.getString(0), cursor.getString(1),
                        cursor.getString(2), cursor.getString(3),
                        cursor.getInt(4), cursor.getString(5)));
            } while (cursor.moveToNext());
        }
        return list;
    }

    public ArrayList<Songs> getalladdBH() {
        ArrayList<Songs> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dataaa.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM addBAIHAT", null);
        if (cursor.getCount() != 0) {
            cursor.moveToFirst();
            do {
                list.add(new Songs(cursor.getString(0), cursor.getString(1),
                        cursor.getString(2), cursor.getString(3),
                        cursor.getInt(4), cursor.getString(5)));
            } while (cursor.moveToNext());
        }
        return list;
    }

    public boolean insertBH(Songs songs){
        SQLiteDatabase db = dataaa.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("hinhanh1", songs.getHinhanh());
        values.put("tenbaihat1", songs.getTenbaihat());
        values.put("file1", songs.getFile());
        values.put("tentacgia1", songs.getTentacgia());
        values.put("luotnghe1", songs.getLuotnghe());
        values.put("theloai1", songs.getTheloai());
        long row = db.insert("addBAIHAT", null, values);

        return (row>0);
    }
}
