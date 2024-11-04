package com.example.finalprojectquizapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText usernameInput;
    private EditText newPasswordInput;
    private EditText confirmPasswordInput;
    private Button resetPasswordButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_forgot_password);

        usernameInput = findViewById(R.id.usernameInput);
        newPasswordInput = findViewById(R.id.newpasswordInput);
        confirmPasswordInput = findViewById(R.id.confirmPasswordInput);
        resetPasswordButton = findViewById(R.id.btnresetpassword);

        resetPasswordButton.setOnClickListener(v ->
        {
            String username = usernameInput.getText().toString();
            String newPassword = newPasswordInput.getText().toString();
            String confirmPassword = confirmPasswordInput.getText().toString();

            if (username.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty())
            {
                Toast.makeText(this, "Please fill up all fields", Toast.LENGTH_SHORT).show();
            }
            else if (!MainActivity.USERNAME_PATTERN.matcher(username).matches())
            {
                Toast.makeText(this, "Username must be 4-20 characters with no spaces", Toast.LENGTH_SHORT).show();
            }
            else if (!MainActivity.PASSWORD_PATTERN.matcher(newPassword).matches())
            {
                Toast.makeText(this, "Password must be at least 6 characters and contain letters", Toast.LENGTH_LONG).show();
            }
            else if (!newPassword.equals(confirmPassword))
            {
                Toast.makeText(this, "Passwords do not match.", Toast.LENGTH_SHORT).show();
            }
            else
            {
                // Handle password reset logic, e.g., updating the password in your database
                Toast.makeText(this, "Password reset successful!", Toast.LENGTH_SHORT).show();
                finish(); // Close the activity after successful reset
            }
        });
    }
}



