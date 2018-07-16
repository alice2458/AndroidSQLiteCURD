package com.example.alice.sqlitecurd.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PersonSqliteHelper extends SQLiteOpenHelper{
    public PersonSqliteHelper(Context context){
        super(context, "person.db", null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE IF NOT EXISTS person(personid integer primary key" +
                " autoincrement, name varchar(20), age INTEGER)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){
    }
}
