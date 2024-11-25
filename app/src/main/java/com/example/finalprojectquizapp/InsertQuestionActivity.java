package com.example.finalprojectquizapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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

        databaseHelper = new DatabaseHelper(this);

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertQuestion();
            }
        });
    }

    private void insertQuestion() {
        String question = questionInput.getText().toString();
        String option1 = option1Input.getText().toString();
        String option2 = option2Input.getText().toString();
        String option3 = option3Input.getText().toString();
        String option4 = option4Input.getText().toString();
        String correctAnswer = correctAnswerInput.getText().toString();

        if (question.isEmpty() || option1.isEmpty() || option2.isEmpty() || option3.isEmpty() || option4.isEmpty() || correctAnswer.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
        } else {
            boolean success = databaseHelper.insertQuestion(question, option1, option2, option3, option4, correctAnswer);
            if (success) {
                Toast.makeText(this, "Question inserted successfully", Toast.LENGTH_SHORT).show();
                clearFields();
            } else {
                Toast.makeText(this, "Failed to insert question", Toast.LENGTH_SHORT).show();
            }
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




