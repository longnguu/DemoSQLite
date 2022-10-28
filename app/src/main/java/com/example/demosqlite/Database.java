package com.example.demosqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;


public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //query
    public void QueryData(String sql){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    public void insert_lop(String malop,String tenlop){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO tblop VALUES(?,?)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(0,malop);
        statement.bindString(1,tenlop);

        statement.executeInsert();
    }
    public void insert_sv(String masv,String tensv,String malop){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO tblop VALUES(?,?,?)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(0,masv);
        statement.bindString(1,tensv);
        statement.bindString(2,malop);


        statement.executeInsert();
    }
    public Boolean update_img(){
        return true;
    }
    public Cursor GetData(String sql){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery(sql,null);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
