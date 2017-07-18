package com.example.com.databasetest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;
    private String newId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new MyDatabaseHelper(this,"BookStore.db",null,2);
        
        Button createDatabase = (Button) findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.getWritableDatabase();
            }
        });
        Button addData = (Button) findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SQLiteDatabase db = dbHelper.getWritableDatabase();
                Uri uri = Uri.parse("content://com.example.com.databasetest.provider/book");
                ContentValues values = new ContentValues();
                //开始组装第一条数据
                values.put("name","A Clash of Kings");
                values.put("author","George Martin");
                values.put("pages",1040);
                values.put("price",22.85);
                Uri newUri = getContentResolver().insert(uri,values);
                newId = newUri.getPathSegments().get(1);
            }
        });
        Button updateData = (Button) findViewById(R.id.update_data);
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SQLiteDatabase db = dbHelper.getWritableDatabase();
                Uri uri = Uri.parse("content://com.example.com.databasetest.provider/book/"+ newId);
                ContentValues values = new ContentValues();
                values.put("name","A Storm of Swords");
                values.put("pages",1216);
                values.put("price",24.05);
                getContentResolver().update(uri,values,null,null);
            }
        });

        Button delectButton = (Button) findViewById(R.id.delect_data);
        delectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SQLiteDatabase db = dbHelper.getWritableDatabase();
                Uri uri = Uri.parse("content://com.example.com.databasetest.provider/book/"+ newId);
                getContentResolver().delete(uri,null,null);
            }
        });

        Button queryButton = (Button) findViewById(R.id.query_data);
        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SQLiteDatabase db = dbHelper.getWritableDatabase();
                //查询Book表中所有的数据
                Uri uri = Uri.parse("content://com.example.com.databasetest.provider/book");
                Cursor cursor = getContentResolver().query(uri,null,null,null,null);
                if (cursor!=null) {
                    while (cursor.moveToNext()){
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));

                        Log.d("MainActivity","Book name is "+ name);
                        Log.d("MainActivity","Book author is " + author);
                        Log.d("MainActivity","Book pages is "+ pages);
                        Log.d("MainActivity","Book price is "+ price);
                    }
                }
                cursor.close();
            }
        });

    }

}
