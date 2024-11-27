package com.example.finalprojectquizapp;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DeleteCatagoryActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_catagory);

        EditText etCategoryName = findViewById(R.id.et_category_name);
        TextView tvCategoryName = findViewById(R.id.tv_catagory_name);
        ImageView ivCategory = findViewById(R.id.iv_category);
        Button btnSearch = findViewById(R.id.btn_search);
        Button btnDeleteCategory = findViewById(R.id.btn_delete_category);

        databaseHelper = new DatabaseHelper(this);
        cursor = databaseHelper.getAllCatagory();

        btnSearch.setOnClickListener(v -> {
            String categoryName = etCategoryName.getText().toString().trim();
            cursor = databaseHelper.getCategoryByName(categoryName);

            if (cursor != null && cursor.moveToFirst()) {

                String name = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_CATEGORY_NAME));
                if(name != null){tvCategoryName.setText(" Catagory Found \n Catagory Name : "+name);}
                else {etCategoryName.setText("Catagory Not Found");}

                byte[] imageBlob = cursor.getBlob(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_CATEGORY_IMAGE_URI));
                Bitmap bitmap = BitmapFactory.decodeByteArray(imageBlob, 0, imageBlob.length);
                ivCategory.setImageBitmap(bitmap);

                btnDeleteCategory.setEnabled(true); // Enable delete button
            } else {
                Toast.makeText(DeleteCatagoryActivity.this, "Category not found", Toast.LENGTH_SHORT).show();
                btnDeleteCategory.setEnabled(false);
            }
        });

        btnDeleteCategory.setOnClickListener(v -> {
            String categoryName = etCategoryName.getText().toString().trim();

            boolean isDeleted = databaseHelper.deleteCategory(categoryName);

            if (isDeleted) {Toast.makeText(DeleteCatagoryActivity.this, "Category deleted successfully", Toast.LENGTH_SHORT).show();}
            else {Toast.makeText(DeleteCatagoryActivity.this, "Failed to delete category", Toast.LENGTH_SHORT).show();}

        });




    }
}