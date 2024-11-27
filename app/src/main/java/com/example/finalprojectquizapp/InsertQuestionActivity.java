package com.example.finalprojectquizapp;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class InsertQuestionActivity extends AppCompatActivity {

    private EditText questionInput, option1Input, option2Input, option3Input, option4Input, correctAnswerInput;
    private Button insertButton;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_question);

        questionInput = findViewById(R.id.questionInput);
        option1Input = findViewById(R.id.option1Input);
        option2Input = findViewById(R.id.option2Input);
        option3Input = findViewById(R.id.option3Input);
        option4Input = findViewById(R.id.option4Input);
        correctAnswerInput = findViewById(R.id.correctAnswerInput);
        insertButton = findViewById(R.id.insertButton);
        Spinner spinner = findViewById(R.id.spinner_catagory);
        databaseHelper = new DatabaseHelper(this);
        populateCategorySpinner(spinner);
        insertButton.setOnClickListener(v -> insertQuestion(spinner));
    }

    private void insertQuestion(Spinner spinner) {

        String question = questionInput.getText().toString();
        String option1 = option1Input.getText().toString();
        String option2 = option2Input.getText().toString();
        String option3 = option3Input.getText().toString();
        String option4 = option4Input.getText().toString();
        String correctAnswer = correctAnswerInput.getText().toString();
        String catagory = spinner.getSelectedItem() != null ? spinner.getSelectedItem().toString() : null;

        if (question.isEmpty() || option1.isEmpty() || option2.isEmpty() || option3.isEmpty() || option4.isEmpty() || correctAnswer.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
        } else {
            boolean success = databaseHelper.insertQuestion(question, option1, option2, option3, option4, correctAnswer, catagory);
            if (success) {
                Toast.makeText(this, "Question inserted successfully", Toast.LENGTH_SHORT).show();
                clearFields();
            } else {
                Toast.makeText(this, "Failed to insert question", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void populateCategorySpinner(Spinner spinner) {
        // Fetch categories from the database
        Cursor cursor = databaseHelper.getAllCategoriesName(); // Assume getAllCategories() returns a Cursor with category data
        List<String> categories = new ArrayList<>();

        if (cursor != null && cursor.moveToFirst()) {
            do {
                String categoryName = cursor.getString(cursor.getColumnIndexOrThrow("categoryName"));
                categories.add(categoryName);
            } while (cursor.moveToNext());
            cursor.close(); // Always close the cursor
        }

        // Set up ArrayAdapter for Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Handle the case where no categories exist
        if (categories.isEmpty()) {
            Toast.makeText(this, "No categories found. Please add categories first.", Toast.LENGTH_SHORT).show();
        }
    }

    private void clearFields() {
        questionInput.setText("");
        option1Input.setText("");
        option2Input.setText("");
        option3Input.setText("");
        option4Input.setText("");
        correctAnswerInput.setText("");
    }
}




