package com.example.finalprojectquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class Register extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText confirmPasswordInput;
    private Button registerButton;
    private TextView loginText;

    private static final Pattern EMAIL_PATTERN = Pattern.compile("[a-z0-9._%+-]+@[a-z0-9.]{6,}");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        usernameEditText = findViewById(R.id.usernameInput);
        emailEditText = findViewById(R.id.emailInput);
        passwordEditText = findViewById(R.id.passwordInput);
        confirmPasswordInput = findViewById(R.id.confirmPasswordInput);
        registerButton = findViewById(R.id.registerButton);
        loginText = findViewById(R.id.loginText);

        registerButton.setOnClickListener(v ->
        {
            String username = usernameEditText.getText().toString();
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            String confirmPassword = confirmPasswordInput.getText().toString();

            if (username.isEmpty())
            {
                usernameEditText.setError("Empty!!");
                usernameEditText.requestFocus();
            }
            else if (!MainActivity.USERNAME_PATTERN.matcher(username).matches())
            {
                Toast.makeText(this, "Username must be 4-20 characters with no spaces", Toast.LENGTH_SHORT).show();
                usernameEditText.requestFocus();
            }
            else if (email.isEmpty())
            {
                emailEditText.setError("Empty!!");
                emailEditText.requestFocus();
            }
            else if (!EMAIL_PATTERN.matcher(email).matches())
            {
                emailEditText.setError("Invalid email format");
                emailEditText.requestFocus();
            }
            else if (password.isEmpty())
            {
                passwordEditText.setError("Empty!!");
                passwordEditText.requestFocus();
            }
            else if (!MainActivity.PASSWORD_PATTERN.matcher(password).matches())
            {
                Toast.makeText(this, "Password must be at least 6 characters and contain letters", Toast.LENGTH_LONG).show();
                passwordEditText.requestFocus();
            }
            else if (!password.equals(confirmPassword))
            {
                confirmPasswordInput.setError("Passwords do not match");
                confirmPasswordInput.requestFocus();
            }
            else
            {
                Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Register.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        loginText.setOnClickListener(v ->
        {
            Intent intent = new Intent(Register.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
