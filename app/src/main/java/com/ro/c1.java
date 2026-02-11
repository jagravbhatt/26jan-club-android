package com.ro;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class c1 extends AppCompatActivity {

    EditText edtFormula;
    String currentInput = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c1);

        edtFormula = findViewById(R.id.edtCalculator2Formula);

        setClick(R.id.btnCalculator2Numberone, "1");
        setClick(R.id.btnCalculator2NumberTwo, "2");
        setClick(R.id.btnCalculator2NumberThree, "3");
        setClick(R.id.btnCalculator2NumberFour, "4");
        setClick(R.id.btnCalculator2NumberFive, "5");
        setClick(R.id.btnCalculator2NumberSix, "6");
        setClick(R.id.btnCalculator2NumberSeven, "7");
        setClick(R.id.btnCalculator2NumberEight, "8");
        setClick(R.id.btnCalculator2NumberNine, "9");
        setClick(R.id.btnCalculator2NumberZero, "0");
        setClick(R.id.btnCalculator2NumberDoubleZero, "00");

//        setClick(R.id.btnCalculator2SignAddition, "+");
        setClick(R.id.btnCalculator2SignAddition,"+");
        setClick(R.id.btnCalculator2SignSubtraction, "-");
        setClick(R.id.btnCalculator2SignMultiplication, "*");
        setClick(R.id.btnCalculator2SignDivision, "/");

        findViewById(R.id.btnCalculator2SignC).setOnClickListener(v -> {
            currentInput = "";
            edtFormula.setText("");
        });

        findViewById(R.id.btnCalculator2Enter).setOnClickListener(v -> calculate());
    }

    private void setClick(int id, String value) {
        findViewById(id).setOnClickListener(v -> {
            currentInput += value;
            edtFormula.setText(currentInput);
        });
    }

    private void calculate() {
        if (currentInput.isEmpty()) {
            Toast.makeText(this, "Enter Value First!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double result = evaluate(currentInput);

            Toast.makeText(this, "Result = " + result, Toast.LENGTH_LONG).show();

        } catch (Exception e) {
            Toast.makeText(this, "Invalid Expression!", Toast.LENGTH_SHORT).show();
        }
    }

    private double evaluate(String expression) {

        if (expression.contains("/0")) {
            throw new ArithmeticException("Divide by zero");
        }

        if (expression.contains("+")) {
            String[] p = expression.split("\\+");
            return Double.parseDouble(p[0]) + Double.parseDouble(p[1]);
        } else if (expression.contains("-")) {
            String[] p = expression.split("\\-");
            return Double.parseDouble(p[0]) - Double.parseDouble(p[1]);
        } else if (expression.contains("*")) {
            String[] p = expression.split("\\*");
            return Double.parseDouble(p[0]) * Double.parseDouble(p[1]);
        } else if (expression.contains("/")) {
            String[] p = expression.split("\\/");
            return Double.parseDouble(p[0]) / Double.parseDouble(p[1]);
        }
        return Double.parseDouble(expression);
    }
}