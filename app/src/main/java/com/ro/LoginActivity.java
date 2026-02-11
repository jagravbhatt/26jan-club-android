package com.ro;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText etEmail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Connect Views
        btnLogin = findViewById(R.id.btnlogin);
        etEmail = findViewById(R.id.estemail);
        etPassword = findViewById(R.id.edtpassword);

        btnLogin.setOnClickListener(v -> {

            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            // Email empty check
            if (TextUtils.isEmpty(email)) {
                etEmail.setError("Email is required");
                etEmail.requestFocus();
                return;
            }

            // Email format check
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.setError("Enter valid email");
                etEmail.requestFocus();
                return;
            }

            // Password empty check
            if (TextUtils.isEmpty(password)) {
                etPassword.setError("Password is required");
                etPassword.requestFocus();
                return;
            }

            // Password length check
            if (password.length() < 6) {
                etPassword.setError("Password must be at least 6 characters");
                etPassword.requestFocus();
                return;
            }

            // If everything correct
            Toast.makeText(LoginActivity.this,
                    "Login Successful",
                    Toast.LENGTH_SHORT).show();

            // Go to Signup Activity
            Intent intent = new Intent(LoginActivity.this, signup.class);
            startActivity(intent);
        });
    }
}
