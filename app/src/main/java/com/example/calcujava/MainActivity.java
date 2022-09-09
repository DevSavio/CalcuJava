package com.example.calcujava;


import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button zero, one, two, three, four, five, six, seven, eight, nine, score, clear, addition, subtraction, multiplication, division, equal;
    private TextView txt_expression, txt_results;
    private ImageView backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialComponents();
        Objects.requireNonNull(getSupportActionBar()).hide();

        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        score.setOnClickListener(this);
        clear.setOnClickListener(this);
        addition.setOnClickListener(this);
        subtraction.setOnClickListener(this);
        multiplication.setOnClickListener(this);
        division.setOnClickListener(this);
        equal.setOnClickListener(this);

        clear.setOnClickListener(view -> {
            txt_expression.setText("");
            txt_results.setText("");
        });

        backspace.setOnClickListener(view -> {
            TextView express = findViewById(R.id.txt_expression);
            String string = express.getText().toString();

            if (!string.isEmpty()) {
                byte var0 = 0;
                int var1 = string.length() - 1;
                String text_expression = string.substring(var0, var1);
                express.setText(text_expression);
            }
            txt_results.setText("");
        });

        equal.setOnClickListener(view -> {
            try {
                Expression expressao = new ExpressionBuilder(txt_expression.getText().toString()).build();
                double resultado = expressao.evaluate();
                long longResult = (long) resultado;

                if (resultado == (double) longResult) {
                    txt_results.setText(String.valueOf(longResult));
                } else {
                    txt_results.setText(String.valueOf(resultado));
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
}

    private void initialComponents() {
        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        score = findViewById(R.id.score);
        clear = findViewById(R.id.clear);
        addition = findViewById(R.id.addition);
        subtraction = findViewById(R.id.subtraction);
        multiplication = findViewById(R.id.multiplication);
        division = findViewById(R.id.division);
        equal = findViewById(R.id.equal);
        txt_expression = findViewById(R.id.txt_expression);
        txt_results = findViewById(R.id.txt_result);
        backspace = findViewById(R.id.backspace);
    }

    public void IncrementNumbers (String string,boolean data_clear){
        if (txt_results.getText().equals("")) {
            txt_expression.setText(" ");
        }
        if (data_clear) {
            txt_results.setText(" ");
            txt_expression.append(string);
        } else {
            txt_expression.append(txt_results.getText());
            txt_expression.append(string);
            txt_results.setText(" ");
        }
    }

        @SuppressLint("NonConstantResourceId")
        @Override
        public void onClick (View view){
            switch (view.getId()) {
                case R.id.zero:
                    IncrementNumbers("0", true);
                    break;
                case R.id.one:
                    IncrementNumbers("1", true);
                    break;
                case R.id.two:
                    IncrementNumbers("2", true);
                    break;
                case R.id.three:
                    IncrementNumbers("3", true);
                    break;
                case R.id.four:
                    IncrementNumbers("4", true);
                    break;
                case R.id.five:
                    IncrementNumbers("5", true);
                    break;
                case R.id.six:
                    IncrementNumbers("6", true);
                    break;
                case R.id.seven:
                    IncrementNumbers("7", true);
                    break;
                case R.id.eight:
                    IncrementNumbers("8", true);
                    break;
                case R.id.nine:
                    IncrementNumbers("9", true);
                    break;
                case R.id.score:
                    IncrementNumbers(".", true);
                    break;
                case R.id.addition:
                    IncrementNumbers("+", false);
                    break;
                case R.id.subtraction:
                    IncrementNumbers("-", false);
                    break;
                case R.id.multiplication:
                    IncrementNumbers("*", false);
                    break;
                case R.id.division:
                    IncrementNumbers("/", false);
                    break;
                case R.id.equal:
                    IncrementNumbers("=", false);
                    break;
            }
        }

}

