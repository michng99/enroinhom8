package com.freesongs.musikplayer8.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.freesongs.musikplayer8.Data.Dataaa;
import com.freesongs.musikplayer8.Model.Songs;
import java.util.ArrayList;

public class DaoBXH {
    Dataaa dataaa;

    public DaoBXH(Context context)
    {
        dataaa = new Dataaa(context);
    }

    public ArrayList<Songs> getBXH(){
        ArrayList<Songs> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dataaa.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM BAIHAT ORDER BY luotnghe DESC",null);
        if (cursor.getCount() != 0 ){
            cursor.moveToFirst();
            do {
                list.add(new Songs( cursor.getString(0) , cursor.getString(1) , cursor.getString(2) , cursor.getString(3) , cursor.getInt(4) , cursor.getString(5) ));
            }while (cursor.moveToNext());
        }
        return list;
    }

}
