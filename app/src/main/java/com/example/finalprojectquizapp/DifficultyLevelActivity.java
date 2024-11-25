//package com.example.finalprojectquizapp;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.widget.Button;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//public class DifficultyLevelActivity extends AppCompatActivity {
//
//    private Button btnEasy, btnMedium, btnHard;
//    private String selectedCategory;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_difficulty_level);
//
//        btnEasy = findViewById(R.id.btnEasy);
//        btnMedium = findViewById(R.id.btnMedium);
//        btnHard = findViewById(R.id.btnHard);
//
//        selectedCategory = getIntent().getStringExtra("category");
//
//        btnEasy.setOnClickListener(view -> startQuiz("Easy"));
//        btnMedium.setOnClickListener(view -> startQuiz("Medium"));
//        btnHard.setOnClickListener(view -> startQuiz("Hard"));
//    }
//
//    private void startQuiz(String difficulty) {
//        Intent intent = new Intent(DifficultyLevelActivity.this, QuizActivity.class);
//        intent.putExtra("category", selectedCategory);
//        intent.putExtra("difficulty", difficulty);
//        startActivity(intent);
//
//    }
//}
//
//





package com.example.finalprojectquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DifficultyLevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_difficulty_level);

    }
}






