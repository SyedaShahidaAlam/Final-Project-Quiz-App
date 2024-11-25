//package com.example.finalprojectquizapp;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//import java.util.ArrayList;
//
//public class CatagoryActivity extends AppCompatActivity {
//
//    private ListView listCategories;
//    private ArrayList<String> categories;
//    private DatabaseHelper dbHelper;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_catagory);
//
//        listCategories = findViewById(R.id.listCategories);
//        dbHelper = new DatabaseHelper(this);
//
//        categories = new ArrayList<>();
//        categories.add("Python");
//        categories.add("Java");
//        categories.add("C++");
//        categories.add("JavaScript");
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, categories);
//        listCategories.setAdapter(adapter);
//
//        listCategories.setOnItemClickListener((AdapterView<?> parent, android.view.View view, int position, long id) -> {
//            String selectedCategory = categories.get(position);
//            Intent intent = new Intent(CatagoryActivity.this, DifficultyLevelActivity.class);
//            intent.putExtra("category", selectedCategory);
//            startActivity(intent);
//        });
//
//    }
//}
//
//





package com.example.finalprojectquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class CatagoryActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_catagory);


    }
}






