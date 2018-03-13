package com.example.yxapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.File;
import java.nio.file.FileAlreadyExistsException;

/**
 * Created by waderwu on 18-3-13.
 */

public class Translate {

    private SQLiteDatabase dictionary;
    private Context context;

    public Translate(Context context){
        Log.d("translate","hahaha");
        this.context = context;

        this.dictionary = new DatabaseHelper(context,"gre.sqlite").openDataBase();
        Cursor cur = this.dictionary.rawQuery("select name from sqlite_master where type='table' ",null);
        if (cur.getCount() > 0){
            cur.moveToFirst();
            Log.d("tablename",cur.getString(0));
        }

    }

    public String getTraslation(String word){
        Cursor cursor = dictionary.rawQuery("select translate from vocab where lower(word) = lower(\""+word+"\");",null);
        if (cursor.getCount() >0){
            cursor.moveToFirst();
            return cursor.getString(0);
        }
        return "no this word";
    }
}
