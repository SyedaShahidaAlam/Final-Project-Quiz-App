package com.example.finalprojectquizapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import Adapter.CatagoryAdapter;
import Database.DatabaseHelper;

public class QuestionCatagoryActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    private Cursor cursor;
    public static final String EXTRA_CATEGORY_NAME = "categoryName"; // Constant for intent extra key

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_catagory2);

        // Initialize database helper and fetch categories
        databaseHelper = new DatabaseHelper(this);
        cursor = databaseHelper.getAllCatagory();

        if (cursor == null || cursor.getCount() == 0) {
            Toast.makeText(this, "No categories found!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Set up RecyclerView with GridLayoutManager
        RecyclerView recyclerView = findViewById(R.id.catagoryRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2)); // Grid with 2 columns
        CatagoryAdapter adapter = new CatagoryAdapter(this, cursor);

        // Set the click listener to handle category name
        adapter.setOnItemClickListener(categoryName -> {
            Log.d("DEBUG", "Clicked Category: " + categoryName); // Debug log
            Intent intent = new Intent(QuestionCatagoryActivity.this, ViewQuestionActivity.class);
            intent.putExtra(EXTRA_CATEGORY_NAME, categoryName); // Pass category name to next activity
            startActivity(intent);

            //Toast.makeText(this, "Clicked: " + categoryName, Toast.LENGTH_SHORT).show();
        });

        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close cursor to avoid memory leaks
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }
}
