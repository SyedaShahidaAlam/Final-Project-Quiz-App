
package com.example.finalprojectquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        ImageView backArrow = findViewById(R.id.adminBackArrow);
        backArrow.setOnClickListener(v ->finish());

        CardView insert, update, view, delete, insertCatagory, deleteCatagory;
        insert = findViewById(R.id.cv_insert);
        update = findViewById(R.id.cv_update);
        view = findViewById(R.id.cv_viewQuestion);
        delete = findViewById(R.id.cv_delete);
        insertCatagory = findViewById(R.id.cv_insert_Catagory);
        deleteCatagory = findViewById(R.id.cv_delete_category);

        insert.setOnClickListener(v -> {Intent intent = new Intent(AdminActivity.this, InsertQuestionActivity.class);startActivity(intent);});
        update.setOnClickListener(v -> {Intent intent = new Intent(AdminActivity.this, UpdateQuestionActivity.class);startActivity(intent);});
        view.setOnClickListener(v -> {Intent intent = new Intent(AdminActivity.this, ViewQuestionActivity.class);startActivity(intent);});
        delete.setOnClickListener(v -> {Intent intent = new Intent(AdminActivity.this, DeleteQuestionActivity.class);startActivity(intent);});
        insertCatagory.setOnClickListener(v -> {Intent intent = new Intent(AdminActivity.this, CatagoryActivity.class);startActivity(intent);});
        deleteCatagory.setOnClickListener(v -> {Intent intent = new Intent(AdminActivity.this, DeleteCatagoryActivity.class);startActivity(intent);});



    }
}



