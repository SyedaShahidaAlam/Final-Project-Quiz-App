//package com.example.finalprojectquizapp;
//
//import android.os.Bundle;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//public class UpdateQuestionActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_update_question);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//    }
//}





package com.example.finalprojectquizapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import Database.DatabaseHelper;

public class UpdateQuestionActivity extends AppCompatActivity {

    private EditText questionIdInput, questionInput, option1Input, option2Input, option3Input, option4Input, correctAnswerInput;
    private Button searchButton, updateButton;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_question);

        questionIdInput = findViewById(R.id.questionIdInput);
        questionInput = findViewById(R.id.questionInput);
        option1Input = findViewById(R.id.option1Input);
        option2Input = findViewById(R.id.option2Input);
        option3Input = findViewById(R.id.option3Input);
        option4Input = findViewById(R.id.option4Input);
        correctAnswerInput = findViewById(R.id.correctAnswerInput);
        searchButton = findViewById(R.id.searchButton);
        updateButton = findViewById(R.id.updateButton);

        databaseHelper = new DatabaseHelper(this);

        // Search Question by ID
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchQuestion();
            }
        });

        // Update Question
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQuestion();
            }
        });
    }

    private void searchQuestion() {
        String questionId = questionIdInput.getText().toString();

        if (questionId.isEmpty()) {
            Toast.makeText(this, "Please enter Question ID", Toast.LENGTH_SHORT).show();
            return;
        }

        Question question = databaseHelper.getQuestionById(Integer.parseInt(questionId));

        if (question != null) {
            questionInput.setText(question.getQuestionText());
            option1Input.setText(question.getOption1());
            option2Input.setText(question.getOption2());
            option3Input.setText(question.getOption3());
            option4Input.setText(question.getOption4());
            correctAnswerInput.setText(question.getAnswer());
        } else {
            Toast.makeText(this, "Question not found", Toast.LENGTH_SHORT).show();
            clearFields();
        }
    }

    private void updateQuestion() {
        String questionId = questionIdInput.getText().toString();
        String questionText = questionInput.getText().toString();
        String option1 = option1Input.getText().toString();
        String option2 = option2Input.getText().toString();
        String option3 = option3Input.getText().toString();
        String option4 = option4Input.getText().toString();
        String correctAnswer = correctAnswerInput.getText().toString();

        if (questionId.isEmpty() || questionText.isEmpty() || option1.isEmpty() ||
                option2.isEmpty() || option3.isEmpty() || option4.isEmpty() || correctAnswer.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean success = databaseHelper.updateQuestion(Integer.parseInt(questionId), questionText, option1, option2, option3, option4, correctAnswer);

        if (success) {
            Toast.makeText(this, "Question updated successfully", Toast.LENGTH_SHORT).show();
            clearFields();
        } else {
            Toast.makeText(this, "Failed to update question", Toast.LENGTH_SHORT).show();
        }
    }

    private void clearFields() {
        questionIdInput.setText("");
        questionInput.setText("");
        option1Input.setText("");
        option2Input.setText("");
        option3Input.setText("");
        option4Input.setText("");
        correctAnswerInput.setText("");
    }
}





