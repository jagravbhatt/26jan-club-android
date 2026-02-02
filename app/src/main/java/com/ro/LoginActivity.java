package com.ro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ro.R;

public class LoginActivity extends AppCompatActivity {

    private EditText edtEmail, edtPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // Make sure this matches your XML file name

        // Initialize UI components
        TextView tvLogin = findViewById(R.id.tvl);
        edtEmail = findViewById(R.id.estemail);
        edtPassword = findViewById(R.id.edtpassword);
        btnLogin = findViewById(R.id.btnlogin);

        // Set click listener for login button
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();

                if(email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please enter email and password", Toast.LENGTH_SHORT).show();
                } else {
                    // Example: Simple hardcoded login check
                    if(email.equals("test@example.com") && password.equals("1234")) {
                        Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();

                        // Navigate to HomeActivity
                        Intent intent = new Intent(LoginActivity.this, signup.class);
                        startActivity(intent);

                        // Optional: close LoginActivity so user can't go back
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
