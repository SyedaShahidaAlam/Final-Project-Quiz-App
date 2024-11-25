//package com.example.finalprojectquizapp;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.CountDownTimer;
//import android.widget.Button;
//import android.widget.RadioButton;
//import android.widget.RadioGroup;
//import android.widget.TextView;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class QuizActivity extends AppCompatActivity {
//
//    private TextView tvQuestion, tvTimer;
//    private RadioGroup radioGroupOptions;
//    private RadioButton rbOption1, rbOption2, rbOption3, rbOption4;
//    private Button btnNext;
//    private List<Question> questions;
//    private int currentQuestionIndex = 0;
//    private int correctAnswers = 0;
//    private CountDownTimer timer;
//    private long timeLeftInMillis = 60000;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_quiz);
//
//        tvQuestion = findViewById(R.id.tvQuestion);
//        tvTimer = findViewById(R.id.tvTimer);
//        radioGroupOptions = findViewById(R.id.radioGroupOptions);
//        rbOption1 = findViewById(R.id.rbOption1);
//        rbOption2 = findViewById(R.id.rbOption2);
//        rbOption3 = findViewById(R.id.rbOption3);
//        rbOption4 = findViewById(R.id.rbOption4);
//        btnNext = findViewById(R.id.btnNext);
//
//        questions = loadQuestions(); // Load questions based on category and difficulty
//        showQuestion();
//
//        btnNext.setOnClickListener(view -> {
//            checkAnswer();
//            currentQuestionIndex++;
//            if (currentQuestionIndex < questions.size()) {
//                showQuestion();
//            } else {
//                timer.cancel();
//                showResult();
//            }
//        });
//
//        startTimer();
//    }
//
//    private void showQuestion() {
//        Question question = questions.get(currentQuestionIndex);
//        tvQuestion.setText(question.getQuestionText());
//        rbOption1.setText(question.getOption1());
//        rbOption2.setText(question.getOption2());
//        rbOption3.setText(question.getOption3());
//        rbOption4.setText(question.getOption4());
//        radioGroupOptions.clearCheck();
//    }
//
//    private void checkAnswer() {
//        int selectedId = radioGroupOptions.getCheckedRadioButtonId();
//        RadioButton selectedRadioButton = findViewById(selectedId);
//        if (selectedRadioButton != null && selectedRadioButton.getText().toString().equals(questions.get(currentQuestionIndex).getAnswer())) {
//            correctAnswers++;
//        }
//    }
//
//    private void startTimer() {
//        timer = new CountDownTimer(timeLeftInMillis, 1000) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//                timeLeftInMillis = millisUntilFinished;
//                tvTimer.setText("Time: " + timeLeftInMillis / 1000);
//            }
//
//            @Override
//            public void onFinish() {
//                showResult();
//            }
//        }.start();
//    }
//
//    private void showResult() {
//        Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
//        intent.putExtra("correctAnswers", correctAnswers);
//        intent.putExtra("totalQuestions", questions.size());
//        startActivity(intent);
//        finish();
//    }
//
//    private List<Question> loadQuestions() {
//        // Fetch questions from the database based on category and difficulty
//        return new ArrayList<>(); // Replace with database query
//    }
//}
//
//





package com.example.finalprojectquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz);

    }
}




