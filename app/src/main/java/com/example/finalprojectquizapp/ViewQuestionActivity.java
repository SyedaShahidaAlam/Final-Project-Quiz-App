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
//import Adapter.QuestionAdapter;
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

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalprojectquizapp.DatabaseHelper;
import com.example.finalprojectquizapp.Question;

import java.util.ArrayList;
import java.util.List;

import Adapter.QuestionAdapter;

public class ViewQuestionActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_question);
        String catagory = getIntent().getStringExtra("catagoryName");
        databaseHelper = new DatabaseHelper(this);
        //cursor = databaseHelper.getAllQuestionsByCatagory(catagory);
        cursor = databaseHelper.getAllQuestions();
        RecyclerView recyclerView = findViewById(R.id.listViewQuestions);

        QuestionAdapter adapter = new QuestionAdapter(this, cursor);

        recyclerView.setAdapter(adapter);



    }
}


