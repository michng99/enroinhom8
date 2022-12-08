package com.freesongs.musikplayer8.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Dataaa extends SQLiteOpenHelper {

    public Dataaa (Context context){
        super(context,"DATA",null,3);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String baihat = " CREATE TABLE BAIHAT ( hinhanh text , tenbaihat text , file text , tentacgia text , luotnghe int , theloai text ) ";
        sqLiteDatabase.execSQL(baihat);

        String user = " CREATE TABLE USER ( id integer primary key autoincrement , username text not null , password text not null ) ";
        sqLiteDatabase.execSQL(user);

        //user
        sqLiteDatabase.execSQL("INSERT INTO USER VALUES (1,'phucthien' , '123')");
        sqLiteDatabase.execSQL("INSERT INTO USER VALUES (2,'minhchuong' , '456')");
        sqLiteDatabase.execSQL("INSERT INTO USER VALUES (3,'anhduy' , '789')");
        sqLiteDatabase.execSQL("INSERT INTO USER VALUES (4,'giahoi' , 'abc')");
        //tết
        sqLiteDatabase.execSQL("INSERT INTO BAIHAT VALUES ( 'thelatet' , 'Thế Là Tết' , 'thelatet' , 'Đức Phúc' , 3407 , 'Tết' )");
        sqLiteDatabase.execSQL("INSERT INTO BAIHAT VALUES ( 'chuctetmoinha' , 'Chúc Tết Mọi Nhà' , 'chuctetmoinha' , 'Quang Huy' , 2407 , 'Tết' )");
        sqLiteDatabase.execSQL("INSERT INTO BAIHAT VALUES ( 'tetnayconseve' , 'Tết Này Con Sẽ Về' , 'tetnayconseve' , 'Thái Sơn' , 3409 , 'Tết' )");
        sqLiteDatabase.execSQL("INSERT INTO BAIHAT VALUES ( 'tetladongmoivui' , 'Tết Là Đông Mới Vui' , 'tetladongmoivui' , 'Đức Phúc' , 2287 , 'Tết' )");
        sqLiteDatabase.execSQL("INSERT INTO BAIHAT VALUES ( 'emchaotet' , 'Em Chào Tết' , 'emchaotet' , 'Thanh Duy' , 3007 , 'Tết' )");
        //rap
        sqLiteDatabase.execSQL("INSERT INTO BAIHAT VALUES ( 'berlin' , 'Berlin' , 'berlin' , 'Trí Tài' , 2407 , 'Rap' )");
        sqLiteDatabase.execSQL("INSERT INTO BAIHAT VALUES ( 'cua' , 'Cua' , 'cua' , 'HieuThu2' , 1407 , 'Rap' )");
        sqLiteDatabase.execSQL("INSERT INTO BAIHAT VALUES ( 'letinh' , 'Lệ Tình' , 'letinh' , 'Phúc T' , 1507 , 'Rap' )");
        sqLiteDatabase.execSQL("INSERT INTO BAIHAT VALUES ( 'thudo' , 'Thủ Đô' , 'thudo' , 'Đức Tài' , 3407 , 'Rap' )");
        sqLiteDatabase.execSQL("INSERT INTO BAIHAT VALUES ( 'wes' , 'Wes' , 'wes' , 'Long Nón Lá' , 679 , 'Rap' )");
        //bolero
        sqLiteDatabase.execSQL("INSERT INTO BAIHAT VALUES ( 'bietdenbaogio' , 'Biết Đến Bao Giờ' , 'bietdenbaogio' , 'Thái Hòa' , 1234 , 'Bolero' )");
        sqLiteDatabase.execSQL("INSERT INTO BAIHAT VALUES ( 'chovualongem' , 'Cho Vừa Lòng Em' , 'chovualongem' , 'Trọng Trề' , 1235 , 'Bolero' )");
        sqLiteDatabase.execSQL("INSERT INTO BAIHAT VALUES ( 'hanhtranggiatu' , 'Hành Trang Giã Từ' , 'hanhtranggiatu' , 'Nhật Hoàng' , 1236 , 'Bolero' )");
        sqLiteDatabase.execSQL("INSERT INTO BAIHAT VALUES ( 'muoimaynamtaingo' , 'Mười Mấy Năm' , 'muoimaynam' , 'Trí Tài' , 1237 , 'Bolero' )");
        sqLiteDatabase.execSQL("INSERT INTO BAIHAT VALUES ( 'saokhongthayanhve' , 'Sao Không Thấy Anh Về' , 'saokhongthayanhve' , 'Minh Chương' , 1238 , 'Bolero' )");
        //usuk
        sqLiteDatabase.execSQL("INSERT INTO BAIHAT VALUES ( 'comethru' , 'Comethru' , 'comethru' , 'Mai Hoa' , 789 , 'Usuk' )");
        sqLiteDatabase.execSQL("INSERT INTO BAIHAT VALUES ( 'dieforyou' , 'Die For You' , 'dieforyou' , 'Baba' , 897 , 'Usuk' )");
        sqLiteDatabase.execSQL("INSERT INTO BAIHAT VALUES ( 'eyesonyou' , 'Eye Son You' , 'eyesonyou' , 'Bale' , 567 , 'Usuk' )");
        sqLiteDatabase.execSQL("INSERT INTO BAIHAT VALUES ( 'fallinlove' , 'Fall In Love' , 'fallinlove' , 'Sasuke' , 1009 , 'Usuk' )");
        sqLiteDatabase.execSQL("INSERT INTO BAIHAT VALUES ( 'loveyourself' , 'Love Your Self' , 'loveyourself' , 'Justin Bieber' , 1078 , 'Usuk' )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i1, int i2) {
        if ( i1 != i2 ){
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS BAIHAT");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS USER");
            onCreate(sqLiteDatabase);
        }
    }
}
