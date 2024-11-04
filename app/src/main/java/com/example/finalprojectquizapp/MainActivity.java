package com.example.finalprojectquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    public static final Pattern USERNAME_PATTERN = Pattern.compile("[a-zA-Z0-9\\S]{4,20}");
    public static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[A-Za-z])[\\d\\D]{6,}$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText usernameEditText = findViewById(R.id.etusername);
        EditText passwordEditText = findViewById(R.id.etpassword);
        TextView forgotPassword = findViewById(R.id.forgotPassword);
        Button loginButton = findViewById(R.id.loginButton);
        TextView signUpText = findViewById(R.id.signUpText);


        loginButton.setOnClickListener(v ->
        {
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            if (username.isEmpty())
            {
                usernameEditText.setError("Empty!!");
                usernameEditText.requestFocus();
            }

            else if (!USERNAME_PATTERN.matcher(username).matches())
            {
                Toast.makeText(this, "Username must be 4-20 characters with no spaces", Toast.LENGTH_SHORT).show();
                usernameEditText.requestFocus();
            }

            else if (password.isEmpty())
            {
                passwordEditText.setError("Empty!!");
                passwordEditText.requestFocus();
            }

            else if (!PASSWORD_PATTERN.matcher(password).matches())
            {
                Toast.makeText(this, "Password must be at least 6 characters and contain letters", Toast.LENGTH_LONG).show();
                passwordEditText.requestFocus();
            }
            else
            {
                if (username.equals("admin") && password.equals("admin"))
                {
                    Toast.makeText(this, "Welcome, Admin!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, AdminActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(this, "Invalid Username or Password!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signUpText.setOnClickListener(v ->
        {
            Intent intent = new Intent(MainActivity.this, Register.class);
            startActivity(intent);
        });

        forgotPassword.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ForgotPasswordActivity.class);
            startActivity(intent);
        });
    }
}



