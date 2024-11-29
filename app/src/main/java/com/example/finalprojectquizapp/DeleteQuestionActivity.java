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
//public class DeleteQuestionActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_delete_question);
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

public class DeleteQuestionActivity extends AppCompatActivity {

    private EditText questionIdInput;
    private Button deleteButton;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_question);

        questionIdInput = findViewById(R.id.questionIdInput);
        deleteButton = findViewById(R.id.deleteButton);

        databaseHelper = new DatabaseHelper(this);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteQuestion();
            }
        });
    }

    private void deleteQuestion() {
        String questionId = questionIdInput.getText().toString();

        if (questionId.isEmpty()) {
            Toast.makeText(this, "Please enter Question ID", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean success = databaseHelper.deleteQuestion(Integer.parseInt(questionId));

        if (success) {
            Toast.makeText(this, "Question deleted successfully", Toast.LENGTH_SHORT).show();
            questionIdInput.setText("");
        } else {
            Toast.makeText(this, "Failed to delete question or Question ID not found", Toast.LENGTH_SHORT).show();
        }
    }
}



