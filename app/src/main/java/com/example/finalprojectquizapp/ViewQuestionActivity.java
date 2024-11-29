package com.example.finalprojectquizapp;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import Adapter.QuestionAdapter;
import Database.DatabaseHelper;

public class ViewQuestionActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    private Cursor cursor;
    private QuestionAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_question2);

        databaseHelper = new DatabaseHelper(this);
        // Retrieve the passed category name
        String categoryName = getIntent().getStringExtra(QuestionCatagoryActivity.EXTRA_CATEGORY_NAME);

        //String categoryName = "cse"; // Replace with dynamic category if needed
        cursor = databaseHelper.getAllQuestionsByCatagory(categoryName);

        RecyclerView recyclerView = findViewById(R.id.listViewQuestions);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new QuestionAdapter(this, cursor, false); // Initially, not submitted
        recyclerView.setAdapter(adapter);

        Button submitButton = findViewById(R.id.btn_submit);
        submitButton.setOnClickListener(v -> {
            adapter.setSubmitted(true); // Mark as submitted to show answers

            int totalCorrect = 0;
            for (int i = 0; i < cursor.getCount(); i++) {
                if (adapter.getCorrectAnswers().get(i, false)) { // Default to false if not answered
                    totalCorrect++;
                }
            }

            Toast.makeText(this, "Total correct answers: " + totalCorrect, Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (cursor != null) {
            cursor.close(); // Close the cursor to avoid memory leaks
        }
    }
}
