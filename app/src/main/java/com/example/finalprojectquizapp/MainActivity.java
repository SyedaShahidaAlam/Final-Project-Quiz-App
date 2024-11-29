//package com.example.finalprojectquizapp;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.WindowManager;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import java.util.regex.Pattern;
//
//public class MainActivity extends AppCompatActivity {
//
//    public static final Pattern USERNAME_PATTERN = Pattern.compile("[a-zA-Z0-9\\S]{4,20}");
//    public static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[A-Za-z])[\\d\\D]{6,}$");
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
//        setContentView(R.layout.activity_main);
//
//        // Reference XML views with correct IDs
//        EditText usernameEditText = findViewById(R.id.usernameInput); // updated ID
//        EditText passwordEditText = findViewById(R.id.etpassword);
//        TextView forgotPassword = findViewById(R.id.forgotPassword);
//        Button loginButton = findViewById(R.id.loginButton);
//        TextView signUpText = findViewById(R.id.signUpText);
//
//        loginButton.setOnClickListener(v -> {
//            String username = usernameEditText.getText().toString();
//            String password = passwordEditText.getText().toString();
//
//            if (username.isEmpty()) {
//                usernameEditText.setError("Empty!!");
//                usernameEditText.requestFocus();
//            } else if (!USERNAME_PATTERN.matcher(username).matches()) {
//                Toast.makeText(this, "Username must be 4-20 characters with no spaces", Toast.LENGTH_SHORT).show();
//                usernameEditText.requestFocus();
//            } else if (password.isEmpty()) {
//                passwordEditText.setError("Empty!!");
//                passwordEditText.requestFocus();
//            } else if (!PASSWORD_PATTERN.matcher(password).matches()) {
//                Toast.makeText(this, "Password must be at least 6 characters and contain letters", Toast.LENGTH_LONG).show();
//                passwordEditText.requestFocus();
//            } else {
//                if (username.equals("admin1234") && password.equals("admin1234")) {
//                    Toast.makeText(this, "Welcome, Admin!", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(MainActivity.this, AdminActivity.class);
//                    startActivity(intent);
//                } else {
//                    Toast.makeText(this, "Invalid Username or Password!", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//
//        signUpText.setOnClickListener(v -> {
//            Intent intent = new Intent(MainActivity.this, Register.class);
//            startActivity(intent);
//        });
//
//        forgotPassword.setOnClickListener(v -> {
//            Intent intent = new Intent(MainActivity.this, ForgotPasswordActivity.class);
//            startActivity(intent);
//        });
//    }
//}




// Last update Not proper code

//package com.example.finalprojectquizapp;
//
//import android.content.Intent;
//import android.database.Cursor;
//import android.os.Bundle;
//import android.view.WindowManager;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import java.util.regex.Pattern;
//
//public class MainActivity extends AppCompatActivity {
//
//    // Username and password patterns
//    public static final Pattern USERNAME_PATTERN = Pattern.compile("[a-zA-Z0-9\\S]{4,20}");
//    public static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[A-Za-z])[\\d\\D]{6,}$");
//
//    private DatabaseHelper databaseHelper; // Database helper instance
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
//        setContentView(R.layout.activity_main);
//
//        // Initialize database helper
//        databaseHelper = new DatabaseHelper(this);
//
//        // Reference XML views
//        EditText usernameEditText = findViewById(R.id.usernameInput);
//        EditText passwordEditText = findViewById(R.id.etpassword);
//        TextView forgotPassword = findViewById(R.id.forgotPassword);
//        Button loginButton = findViewById(R.id.loginButton);
//        TextView signUpText = findViewById(R.id.signUpText);
//
//        // Handle login button click
//        loginButton.setOnClickListener(v -> {
//            String username = usernameEditText.getText().toString().trim();
//            String password = passwordEditText.getText().toString().trim();
//
//            // Validate inputs
//            if (username.isEmpty()) {
//                usernameEditText.setError("Username cannot be empty");
//                usernameEditText.requestFocus();
//            } else if (!USERNAME_PATTERN.matcher(username).matches()) {
//                Toast.makeText(this, "Username must be 4-20 characters with no spaces", Toast.LENGTH_SHORT).show();
//                usernameEditText.requestFocus();
//            } else if (password.isEmpty()) {
//                passwordEditText.setError("Password cannot be empty");
//                passwordEditText.requestFocus();
//            } else if (!PASSWORD_PATTERN.matcher(password).matches()) {
//                Toast.makeText(this, "Password must be at least 6 characters and contain letters", Toast.LENGTH_LONG).show();
//                passwordEditText.requestFocus();
//            } else {
//                handleLogin(username, password);
//            }
//        });
//
//        // Handle sign-up text click
//        signUpText.setOnClickListener(v -> {
//            Intent intent = new Intent(MainActivity.this, Register.class);
//            startActivity(intent);
//        });
//
//        // Handle forgot password text click
//        forgotPassword.setOnClickListener(v -> {
//            Intent intent = new Intent(MainActivity.this, ForgotPasswordActivity.class);
//            startActivity(intent);
//        });
//    }
//
//    private void handleLogin(String username, String password) {
//        // Admin login logic
//        if (username.equals("admin123") && password.equals("admin123")) {
//            Toast.makeText(this, "Welcome, Admin!", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(MainActivity.this, AdminActivity.class);
//            startActivity(intent);
//        } else {
//            // User login logic
//            Cursor cursor = databaseHelper.getReadableDatabase().rawQuery(
//                    "SELECT * FROM users WHERE username = ? AND password = ?",
//                    new String[]{username, password}
//            );
//
//            if (cursor.moveToFirst()) {
//                Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(MainActivity.this, CatagoryActivity.class);
//                startActivity(intent);
//            } else {
//                Toast.makeText(this, "Invalid Username or Password!", Toast.LENGTH_SHORT).show();
//            }
//
//            cursor.close();
//        }
//    }
//}




// properly work login connection with database

package com.example.finalprojectquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

import Database.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    public static final Pattern USERNAME_PATTERN = Pattern.compile("[a-zA-Z0-9\\S]{4,20}");
    public static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[A-Za-z])[\\d\\D]{6,}$");

    private DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);

        // Reference XML views with correct IDs
        EditText usernameEditText = findViewById(R.id.usernameInput); // updated ID
        EditText passwordEditText = findViewById(R.id.etpassword);
        TextView forgotPassword = findViewById(R.id.forgotPassword);
        Button loginButton = findViewById(R.id.loginButton);
        TextView signUpText = findViewById(R.id.signUpText);

        loginButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            if (username.isEmpty()) {
                usernameEditText.setError("Empty!!");
                usernameEditText.requestFocus();
            } else if (!USERNAME_PATTERN.matcher(username).matches()) {
                Toast.makeText(this, "Username must be 4-20 characters with no spaces", Toast.LENGTH_SHORT).show();
                usernameEditText.requestFocus();
            } else if (password.isEmpty()) {
                passwordEditText.setError("Empty!!");
                passwordEditText.requestFocus();
            } else if (!PASSWORD_PATTERN.matcher(password).matches()) {
                Toast.makeText(this, "Password must be at least 6 characters and contain letters", Toast.LENGTH_LONG).show();
                passwordEditText.requestFocus();
            } else {
                // Check for admin credentials first
                if (username.equals("admin1234") && password.equals("admin1234")) {
                    Toast.makeText(this, "Admin Login Successful!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, AdminActivity.class);
                    startActivity(intent);
                } else {
                    // Validate credentials using DatabaseHelper
                    boolean isLoggedIn = databaseHelper.loginUser(username, password);
                    if (isLoggedIn) {
                        Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, QuestionCatagoryActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(this, "Invalid Username or Password!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // Sign-up text listener
        signUpText.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Register.class);
            startActivity(intent);
        });

        // Forgot password listener
        forgotPassword.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ForgotPasswordActivity.class);
            startActivity(intent);
        });
    }
}




