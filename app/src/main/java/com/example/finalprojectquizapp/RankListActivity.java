//package com.example.finalprojectquizapp;
//
//import android.os.Bundle;
//import android.widget.ListView;
//import android.widget.SimpleAdapter;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
//public class RankListActivity extends AppCompatActivity {
//
//    private ListView listRank;
//    private DatabaseHelper dbHelper;
//    private ArrayList<HashMap<String, String>> rankList;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_rank_list);
//
//        listRank = findViewById(R.id.listRank);
//        dbHelper = new DatabaseHelper(this);
//
//        rankList = dbHelper.getRankList();
//
//        SimpleAdapter adapter = new SimpleAdapter(
//                this,
//                rankList,
//                android.R.layout.simple_list_item_2,
//                new String[]{"username", "score"},
//                new int[]{android.R.id.text1, android.R.id.text2}
//        );
//
//        listRank.setAdapter(adapter);
//
//    }
//}







package com.example.finalprojectquizapp;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class RankListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rank_list);

    }
}






