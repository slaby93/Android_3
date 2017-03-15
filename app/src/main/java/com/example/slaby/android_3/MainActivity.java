package com.example.slaby.android_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Calculator c;


    MainActivity() {
        c = new Calculator();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onNumberClick(View view) {
        Button thisButton = (Button) view;
        Integer inputedNumber = Integer.parseInt((String) thisButton.getText());
        c.inputNumber(inputedNumber);
        updateResults();

    }

    public void onOperation(View view) {
        Button btn = (Button) view;
        String operation = (String) btn.getText();

        switch (operation) {
            case "+":
            case "-":
            case "*":
            case "/":
                c.addOperation(operation);
                break;
            case "=":
                c.equal();
                break;
        }
        updateResults();

    }

    public void updateResults() {
        TextView result0 = (TextView) findViewById(R.id.result0);
        result0.setText(c.getMath());
    }

}
