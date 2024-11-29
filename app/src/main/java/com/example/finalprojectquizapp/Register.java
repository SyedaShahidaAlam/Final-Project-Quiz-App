//package com.example.finalprojectquizapp;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import java.util.regex.Pattern;
//
//public class Register extends AppCompatActivity {
//
//    private EditText usernameEditText;
//    private EditText emailEditText;
//    private EditText passwordEditText;
//    private EditText confirmPasswordInput;
//    private Button registerButton;
//    private TextView loginText;
//
//    // Updated email pattern to match a typical format for validation
//    private static final Pattern EMAIL_PATTERN = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_register);
//
//        // Reference XML views with correct IDs
//        usernameEditText = findViewById(R.id.usernameInput);
//        emailEditText = findViewById(R.id.emailInput);
//        passwordEditText = findViewById(R.id.passwordInput);
//        confirmPasswordInput = findViewById(R.id.confirmPasswordInput);
//        registerButton = findViewById(R.id.registerButton);
//        loginText = findViewById(R.id.loginText);
//
//        registerButton.setOnClickListener(v -> {
//            String username = usernameEditText.getText().toString();
//            String email = emailEditText.getText().toString();
//            String password = passwordEditText.getText().toString();
//            String confirmPassword = confirmPasswordInput.getText().toString();
//
//            if (username.isEmpty()) {
//                usernameEditText.setError("Empty!!");
//                usernameEditText.requestFocus();
//            } else if (!MainActivity.USERNAME_PATTERN.matcher(username).matches()) {
//                Toast.makeText(this, "Username must be 4-20 characters with no spaces", Toast.LENGTH_SHORT).show();
//                usernameEditText.requestFocus();
//            } else if (email.isEmpty()) {
//                emailEditText.setError("Empty!!");
//                emailEditText.requestFocus();
//            } else if (!EMAIL_PATTERN.matcher(email).matches()) {
//                emailEditText.setError("Invalid email format");
//                emailEditText.requestFocus();
//            } else if (password.isEmpty()) {
//                passwordEditText.setError("Empty!!");
//                passwordEditText.requestFocus();
//            } else if (!MainActivity.PASSWORD_PATTERN.matcher(password).matches()) {
//                Toast.makeText(this, "Password must be at least 6 characters and contain letters", Toast.LENGTH_LONG).show();
//                passwordEditText.requestFocus();
//            } else if (!password.equals(confirmPassword)) {
//                confirmPasswordInput.setError("Passwords do not match");
//                confirmPasswordInput.requestFocus();
//            } else {
//                Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(Register.this, MainActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
//
//        loginText.setOnClickListener(v -> {
//            Intent intent = new Intent(Register.this, MainActivity.class);
//            startActivity(intent);
//            finish();
//        });
//    }
//}





// Last Not proper code

//package com.example.finalprojectquizapp;
//
//import android.content.ContentValues;
//import android.content.Intent;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import java.util.regex.Pattern;
//
//public class Register extends AppCompatActivity {
//
//    private EditText usernameEditText;
//    private EditText emailEditText;
//    private EditText passwordEditText;
//    private EditText confirmPasswordInput;
//    private Button registerButton;
//    private TextView loginText;
//    private DatabaseHelper databaseHelper;
//
//    // Updated email pattern to match a typical format for validation
//    private static final Pattern EMAIL_PATTERN = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_register);
//
//        databaseHelper = new DatabaseHelper(this); // Initialize database helper
//
//        // Reference XML views with correct IDs
//        usernameEditText = findViewById(R.id.usernameInput);
//        emailEditText = findViewById(R.id.emailInput);
//        passwordEditText = findViewById(R.id.passwordInput);
//        confirmPasswordInput = findViewById(R.id.confirmPasswordInput);
//        registerButton = findViewById(R.id.registerButton);
//        loginText = findViewById(R.id.loginText);
//
//        registerButton.setOnClickListener(v -> {
//            String username = usernameEditText.getText().toString().trim();
//            String email = emailEditText.getText().toString().trim();
//            String password = passwordEditText.getText().toString().trim();
//            String confirmPassword = confirmPasswordInput.getText().toString().trim();
//
//            if (username.isEmpty()) {
//                usernameEditText.setError("Username cannot be empty");
//                usernameEditText.requestFocus();
//            } else if (!MainActivity.USERNAME_PATTERN.matcher(username).matches()) {
//                Toast.makeText(this, "Username must be 4-20 characters with no spaces", Toast.LENGTH_SHORT).show();
//                usernameEditText.requestFocus();
//            } else if (email.isEmpty()) {
//                emailEditText.setError("Email cannot be empty");
//                emailEditText.requestFocus();
//            } else if (!EMAIL_PATTERN.matcher(email).matches()) {
//                emailEditText.setError("Invalid email format");
//                emailEditText.requestFocus();
//            } else if (password.isEmpty()) {
//                passwordEditText.setError("Password cannot be empty");
//                passwordEditText.requestFocus();
//            } else if (!MainActivity.PASSWORD_PATTERN.matcher(password).matches()) {
//                Toast.makeText(this, "Password must be at least 6 characters and contain letters", Toast.LENGTH_LONG).show();
//                passwordEditText.requestFocus();
//            } else if (!password.equals(confirmPassword)) {
//                confirmPasswordInput.setError("Passwords do not match");
//                confirmPasswordInput.requestFocus();
//            } else {
//                // Check if username already exists
//                SQLiteDatabase db = databaseHelper.getReadableDatabase();
//                Cursor cursor = db.rawQuery("SELECT * FROM users WHERE username = ?", new String[]{username});
//
//                if (cursor.moveToFirst()) {
//                    Toast.makeText(this, "Username already exists. Choose a different one.", Toast.LENGTH_SHORT).show();
//                } else {
//                    // Save user details in the database
//                    ContentValues values = new ContentValues();
//                    values.put("username", username);
//                    values.put("email", email);
//                    values.put("password", password);
//
//                    long result = db.insert("users", null, values);
//
//                    if (result != -1) {
//                        Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show();
//                        startActivity(new Intent(Register.this, MainActivity.class));
//                        finish();
//                    } else {
//                        Toast.makeText(this, "Error! Try again.", Toast.LENGTH_SHORT).show();
//                    }
//                }
//
//                cursor.close();
//                db.close();
//            }
//        });
//
//        loginText.setOnClickListener(v -> {
//            Intent intent = new Intent(Register.this, MainActivity.class);
//            startActivity(intent);
//            finish();
//        });
//    }
//}





// properly work regester connection with database

package com.example.finalprojectquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

import Database.DatabaseHelper;

public class Register extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText confirmPasswordInput;
    private Button registerButton;
    private TextView loginText;

    // Updated email pattern to match a typical format for validation
    private static final Pattern EMAIL_PATTERN = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        databaseHelper = new DatabaseHelper(this);

        // Reference XML views with correct IDs
        usernameEditText = findViewById(R.id.usernameInput);
        emailEditText = findViewById(R.id.emailInput);
        passwordEditText = findViewById(R.id.passwordInput);
        confirmPasswordInput = findViewById(R.id.confirmPasswordInput);
        registerButton = findViewById(R.id.registerButton);
        loginText = findViewById(R.id.loginText);

        registerButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString().trim();
            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();
            String confirmPassword = confirmPasswordInput.getText().toString().trim();

            if (username.isEmpty()) {
                usernameEditText.setError("Empty!!");
                usernameEditText.requestFocus();
            } else if (!MainActivity.USERNAME_PATTERN.matcher(username).matches()) {
                Toast.makeText(this, "Username must be 4-20 characters with no spaces", Toast.LENGTH_SHORT).show();
                usernameEditText.requestFocus();
            } else if (email.isEmpty()) {
                emailEditText.setError("Empty!!");
                emailEditText.requestFocus();
            } else if (!EMAIL_PATTERN.matcher(email).matches()) {
                emailEditText.setError("Invalid email format");
                emailEditText.requestFocus();
            } else if (password.isEmpty()) {
                passwordEditText.setError("Empty!!");
                passwordEditText.requestFocus();
            } else if (!MainActivity.PASSWORD_PATTERN.matcher(password).matches()) {
                Toast.makeText(this, "Password must be at least 6 characters and contain letters", Toast.LENGTH_LONG).show();
                passwordEditText.requestFocus();
            } else if (!password.equals(confirmPassword)) {
                confirmPasswordInput.setError("Passwords do not match");
                confirmPasswordInput.requestFocus();
            } else {
                // Check if username already exists
                if (databaseHelper.isUsernameTaken(username)) {
                    Toast.makeText(this, "Username is already taken. Try another!", Toast.LENGTH_LONG).show();
                    usernameEditText.requestFocus();
                } else {
                    // Attempt to register user
                    boolean isRegistered = databaseHelper.registerUser(username, email, password);
                    if (isRegistered) {
                        Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Register.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(this, "Registration failed. Try again!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        loginText.setOnClickListener(v -> {
            Intent intent = new Intent(Register.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}


