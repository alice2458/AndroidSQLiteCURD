package com.example.alice.sqlitecurd.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.support.annotation.RequiresApi;

import com.example.alice.sqlitecurd.db.PersonSqliteHelper;
import com.example.alice.sqlitecurd.domain.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
    private PersonSqliteHelper helper;
    private PersonDAO(Context context){
        helper = new PersonSqliteHelper(context);
    }
    public void add(String newName, String newAge){
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "insert into person(name, age) values(?,?)";
        db.execSQL(sql, new Object[]{newName, newAge});
        db.close();
    }
    public boolean find(String newName){
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "select * from person where name=?";
        Cursor cursor = db.rawQuery(sql, new String[]{newName});
        boolean result = cursor.moveToNext();
        cursor.close();
        db.close();
        return result;
    }
    public void update(String name, int age){
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "update person set age=? where name=?";
        db.execSQL(sql, new Object[]{age, name});
        db.close();
    }
    public void delete(String name){
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "delete from person where name=?";
        db.execSQL(sql, new Object[]{name});
        db.close();
    }
    public List<Person> findAll(){
        SQLiteDatabase db = helper.getReadableDatabase();
        List<Person> list = new ArrayList<>();
        String sql = "select * from person";
        Cursor cursor = db.rawQuery(sql, null);
        while(cursor.moveToNext()){
            int personid = cursor.getInt(cursor.getColumnIndex("personid"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            int age = cursor.getInt(cursor.getColumnIndex("age"));
            Person p = new Person(personid, name, age);
            list.add(p);
        }
        cursor.close();
        db.close();
        return list;
    }
}
