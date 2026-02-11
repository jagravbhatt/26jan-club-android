package com.ro;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class forgotpassword extends AppCompatActivity {

    EditText edtemail;
    Button btnForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);

        edtemail = findViewById(R.id.edtemail);
        btnForgotPassword = findViewById(R.id.btnForgotPassword);

        btnForgotPassword.setOnClickListener(v -> validateEmail());
    }

    private void validateEmail() {

        String email = edtemail.getText().toString().trim();

        if (email.isEmpty()) {
            edtemail.setError("Email is required!");
            edtemail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edtemail.setError("Enter valid email!");
            edtemail.requestFocus();
            return;
        }

        Toast.makeText(this, "Reset link sent to " + email, Toast.LENGTH_LONG).show();
    }
}
