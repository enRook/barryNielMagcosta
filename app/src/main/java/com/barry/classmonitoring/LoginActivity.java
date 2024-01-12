package com.barry.classmonitoring;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private static final String VALID_USERNAME = "SLSU";
    private static final String VALID_PASSWORD = "2024";

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views
        usernameEditText = findViewById(R.id.editTextText_Username);
        passwordEditText = findViewById(R.id.editTextTextPassword);
        loginButton = findViewById(R.id.loginButton);

        // Set click listener for login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Call method to handle login
                handleLogin();
            }
        });
    }
    private void handleLogin() {
        // Get entered username and password
        String enteredUsername = usernameEditText.getText().toString();
        String enteredPassword = passwordEditText.getText().toString();

        // Check for empty fields
        if (enteredUsername.isEmpty() || enteredPassword.isEmpty()) {
            showToast("Please enter both username and password.");
            return;
        }

        // Check if username and password are valid
        if (isValidCredentials(enteredUsername, enteredPassword)) {
            // Successful login, navigate to MainActivity
            showToast("Login successful!");

            // Create an intent to start MainActivity
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);

            // Finish the current LoginActivity to prevent navigating back to it
            finish();
        } else {
            // Invalid credentials, show error message
            showToast("Invalid username or password. Please try again.");
        }
    }

    private boolean isValidCredentials(String username, String password) {
        // Check if entered username and password match the valid credentials
        return VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password);
    }

    private void showToast(String message) {
        // Helper method to show Toast messages
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
