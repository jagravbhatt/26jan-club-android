package com.ro;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class signup extends AppCompatActivity {

//    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

//        btnNext = findViewById(R.id.btnsignup);
//
//        btnNext.setOnClickListener(v -> {
           Intent intent = new Intent(signup.this, MainActivity.class);
           startActivity(intent);
    }
}