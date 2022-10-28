package com.example.demosqlite;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    Database db;

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new Database(this,"QLSV1.sqlite",null,1);
        db.QueryData("create table IF NOT EXISTS TBLOP(MALOP VARCHAR(100),TENLOP nVARCHAR(100))");
        db.QueryData("create table IF NOT EXISTS TBSV(MASV VARCHAR(100),TENSV VARCHAR(100),MALOP VARCHAR(100))");
        ListView lvLop = (ListView) findViewById(R.id.lvLop);
        List<Lop> dsLop= new ArrayList<Lop>();
        Cursor cursor = db.GetData("select * from tblop");
        System.out.println("ABC " + cursor.getCount());
        if (cursor.getCount()>0){
            System.out.println("abc");
            while (cursor.moveToNext()){
                String malop = cursor.getString(cursor.getColumnIndex("MALOP"));
                String tenlop = cursor.getString(cursor.getColumnIndex("TENLOP"));
                dsLop.add(new Lop(malop,tenlop));
            }
        }
//        else System.out.println("BCS");
        ArrayAdapter<Lop> lopArrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,dsLop);
        lvLop.setAdapter(lopArrayAdapter);
        lvLop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,SinhVienActivity.class);
                intent.putExtra("malop",dsLop.get(i).getMalop());
                startActivity(intent);
            }
        });
    }
}