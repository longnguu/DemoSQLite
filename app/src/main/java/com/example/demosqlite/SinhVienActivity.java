package com.example.demosqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SinhVienActivity extends AppCompatActivity {
    Database db;

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinh_vien);
        db = new Database(this,"QLSV1.sqlite",null,1);
        Intent intent = getIntent();
        ListView listView = (ListView) findViewById(R.id.lvsv);
        List<SinhVien> dssv = new ArrayList<SinhVien>();
        String malop = intent.getStringExtra("malop");
        System.out.println(malop);
        Cursor cursor = db.GetData("Select * from tbsv where MALOP = '"+ malop+"'");
        while (cursor.moveToNext()){
            dssv.add(new SinhVien(cursor.getString(cursor.getColumnIndex("MASV")),cursor.getString(cursor.getColumnIndex("TENSV")),cursor.getString(cursor.getColumnIndex("MALOP"))));
        }
        ArrayAdapter<SinhVien> sinhVienArrayAdapter = new ArrayAdapter<>(SinhVienActivity.this, android.R.layout.simple_list_item_1,dssv);
        listView.setAdapter(sinhVienArrayAdapter);
    }
}