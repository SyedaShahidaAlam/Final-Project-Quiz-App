package com.example.finalprojectquizapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import Adapter.CatagoryAdapter;

public class QuestionCatagoryActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_catagory2);

        databaseHelper = new DatabaseHelper(this);
        cursor = databaseHelper.getAllCatagory();

        RecyclerView recyclerView = findViewById(R.id.catagoryRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2)); // 2 columns in grid
        CatagoryAdapter adapter = new CatagoryAdapter(this, cursor);
        adapter.setOnItemClickListener(position -> {
            if (cursor.moveToPosition(position)) {
                String catagoryName = cursor.getString(cursor.getColumnIndexOrThrow("category"));

                // Start product detail activity
                Intent intent = new Intent(QuestionCatagoryActivity.this, ViewQuestionActivity.class);
                intent.putExtra("catagoryName", catagoryName);
                startActivity(intent);

                Toast.makeText(this, "Clicked: " + catagoryName, Toast.LENGTH_SHORT).show();
            }

        });
        recyclerView.setAdapter(adapter);



    }
}