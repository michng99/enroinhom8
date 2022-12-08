package com.freesongs.musikplayer8.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.freesongs.musikplayer8.Data.Dataaa;
import com.freesongs.musikplayer8.Model.User;

public class DaoUser {

    Dataaa dataaa ;

    public DaoUser(Context context) {
        dataaa = new Dataaa(context);
    }

    public User Login(String username , String password) {
        SQLiteDatabase database = dataaa.getReadableDatabase();
        String query = "select * from USER where username = ?";
        Cursor cursor = database.rawQuery(query, new String[]{username});
        User user = null;
        try {
            if (cursor.moveToFirst())
            {
                while (!cursor.isAfterLast())
                {
                    @SuppressLint("Range") Integer _id = cursor.getInt(cursor.getColumnIndex("id"));
                    @SuppressLint("Range") String _username = cursor.getString(cursor.getColumnIndex("username"));
                    @SuppressLint("Range") String _password = cursor.getString(cursor.getColumnIndex("password"));
                    if (!password.equals(_password))
                    {
                        break;
                    }
                    user = new User();
                    user.setId(_id);
                    user.setUsername(_username);
                    cursor.moveToNext();
                }
            }
        }
        catch (Exception e) {
        }
        finally {
            if (cursor != null && !cursor.isClosed())
            {
                cursor.close();
            }
        }
        return user;
    }

    public boolean register (String username, String password) {
        Boolean result = false;
        SQLiteDatabase database = dataaa.getWritableDatabase();
        database.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put("username",username);
            values.put("password",password);
            long rows = database.insertOrThrow("USER",null,values);
            database.setTransactionSuccessful();
            result = rows >= 1;
        }
        catch (Exception e) {
        }
        finally {
            database.endTransaction();
        }
        return result;
    }

    public User checkuser(String username) {
        SQLiteDatabase database = dataaa.getReadableDatabase();
        String query = "select * from USER where username = ?";
        Cursor cursor = database.rawQuery(query, new String[]{username});
        User user = null;
        try {
            if (cursor.moveToFirst())
            {
                while (!cursor.isAfterLast())
                {
                    @SuppressLint("Range") String _username = cursor.getString(cursor.getColumnIndex("username"));
                    user = new User();
                    user.setUsername(_username);
                    cursor.moveToNext();
                }
            }
        }
        catch (Exception e) {
        }
        finally {
            if (cursor != null && !cursor.isClosed())
            {
                cursor.close();
            }
        }
        return user;
    }


}
