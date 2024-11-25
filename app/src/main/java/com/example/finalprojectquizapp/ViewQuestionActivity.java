//package com.example.finalprojectquizapp;
//
//import android.os.Bundle;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import android.annotation.SuppressLint;
//import android.os.Bundle;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.finalprojectquizapp.DatabaseHelper;
//import com.example.finalprojectquizapp.Question;
//import com.example.finalprojectquizapp.QuestionAdapter;
//import com.example.finalprojectquizapp.R;
//
//import java.util.List;
//
//public class ViewQuestionActivity extends AppCompatActivity {
//
//    private RecyclerView recyclerViewQuestions;
//    private QuestionAdapter questionAdapter;
//    private DatabaseHelper databaseHelper;
//
//    @SuppressLint("MissingInflatedId")
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_view_question);
//
//        recyclerViewQuestions = findViewById(R.id.recyclerViewQuestions);
//        recyclerViewQuestions.setLayoutManager(new LinearLayoutManager(this));
//
//        databaseHelper = new DatabaseHelper(this);
//        List<Question> questionList = databaseHelper.getAllQuestions();
//
//        questionAdapter = new QuestionAdapter(questionList);
//        recyclerViewQuestions.setAdapter(questionAdapter);
//    }
//}
//
//




package com.example.finalprojectquizapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalprojectquizapp.DatabaseHelper;
import com.example.finalprojectquizapp.Question;

import java.util.ArrayList;
import java.util.List;

public class ViewQuestionActivity extends AppCompatActivity {

    private ListView listViewQuestions;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_question); // Make sure your XML layout has ListView

        listViewQuestions = findViewById(R.id.listViewQuestions);
        databaseHelper = new DatabaseHelper(this);

        // Get all questions from the database
        List<Question> questionList = databaseHelper.getAllQuestions();

        // Convert the question objects to a list of question texts
        ArrayList<String> questionTexts = new ArrayList<>();
        for (Question question : questionList) {
            questionTexts.add(question.getQuestionText());
        }

        // Set up an ArrayAdapter to display questions in the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1, // Default layout for list items
                questionTexts
        );

        listViewQuestions.setAdapter(adapter);
    }
}


