//package com.example.finalprojectquizapp;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//public class ResultActivity extends AppCompatActivity {
//
//    private TextView tvResultSummary;
//    private ProgressBar progressBar;
//    private Button btnViewRank;
//    private int correctAnswers, totalQuestions;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_result);
//
//        tvResultSummary = findViewById(R.id.tvResultSummary);
//        progressBar = findViewById(R.id.progressBar);
//        btnViewRank = findViewById(R.id.btnViewRank);
//
//        correctAnswers = getIntent().getIntExtra("correctAnswers", 0);
//        totalQuestions = getIntent().getIntExtra("totalQuestions", 0);
//
//        String resultSummary = "Correct: " + correctAnswers + "\nWrong: " + (totalQuestions - correctAnswers);
//        tvResultSummary.setText(resultSummary);
//
//        progressBar.setMax(totalQuestions);
//        progressBar.setProgress(correctAnswers);
//
//        btnViewRank.setOnClickListener(view -> {
//            Intent intent = new Intent(ResultActivity.this, RankListActivity.class);
//            startActivity(intent);
//        });
//
//    }
//}
//
//
//





package com.example.finalprojectquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);

    }
}






