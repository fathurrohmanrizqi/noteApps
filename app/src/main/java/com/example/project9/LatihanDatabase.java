package com.example.project9;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;

public class LatihanDatabase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_latihan_database);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        File path = getApplication().getFilesDir();
        try {
            SQLiteDatabase db = SQLiteDatabase.openDatabase(path+"databases/digidaw11.db", null, SQLiteDatabase.CREATE_IF_NECESSARY);

            ContentValues contentValues = new ContentValues();
            contentValues.put("title","buku1");
            contentValues.put("isbn","buku1");
            contentValues.put("title","buku1");


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}