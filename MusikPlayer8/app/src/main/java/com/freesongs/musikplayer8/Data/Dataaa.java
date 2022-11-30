package com.freesongs.musikplayer8.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Dataaa extends SQLiteOpenHelper {

    public Dataaa (Context context){
        super(context,"DATA",null,2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String baihat = " CREATE TABLE BAIHAT ( tenbaihat text , file text ) ";
        sqLiteDatabase.execSQL(baihat);

        sqLiteDatabase.execSQL(" INSERT INTO BAIHAT VALUES ( 'Chuc Tet Moi Nha','R.raw.chuctetmoinha' ) , ( 'Em Chao Tet','R.raw.emchaotet' ) , ( 'Tet La Dong Moi Vui','R.raw.tetladongmoivui' ) , ( 'Tet Nay Con Se Ve','R.raw.tetnayconseve' ) ");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i1, int i2) {
        if ( i1 != i2 ){
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS BAIHAT");
            onCreate(sqLiteDatabase);
        }
    }
}
