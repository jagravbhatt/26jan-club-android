package com.ro;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class signup extends AppCompatActivity {

    private Button btnSignup;
    private EditText etName, etEmail, etPassword, etConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btnSignup = findViewById(R.id.btnsignup);
        etName = findViewById(R.id.edtname);
        etEmail = findViewById(R.id.edtemail);
        etPassword = findViewById(R.id.edtpassword);


        btnSignup.setOnClickListener(v -> {

            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            String confirmPassword = etConfirmPassword.getText().toString().trim();

            // Name check
            if (TextUtils.isEmpty(name)) {
                etName.setError("Name is required");
                etName.requestFocus();
                return;
            }

            // Email check
            if (TextUtils.isEmpty(email)) {
                etEmail.setError("Email is required");
                etEmail.requestFocus();
                return;
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.setError("Enter valid email");
                etEmail.requestFocus();
                return;
            }

            // Password check
            if (TextUtils.isEmpty(password)) {
                etPassword.setError("Password is required");
                etPassword.requestFocus();
                return;
            }

            if (password.length() < 6) {
                etPassword.setError("Password must be at least 6 characters");
                etPassword.requestFocus();
                return;
            }

            // Confirm password check
            if (!password.equals(confirmPassword)) {
                etConfirmPassword.setError("Passwords do not match");
                etConfirmPassword.requestFocus();
                return;
            }

            // If all valid
            Toast.makeText(signup.this,
                    "Signup Successful",
                    Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(signup.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
