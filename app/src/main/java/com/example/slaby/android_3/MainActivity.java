package com.example.slaby.android_3;

import android.os.Vibrator;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Calculator c;


    public void initCalc() {
        c = new Calculator();
        TextView re0 = (TextView) findViewById(R.id.result0);
        TextView re1 = (TextView) findViewById(R.id.result1);
        TextView re2 = (TextView) findViewById(R.id.result2);
        TextView re3 = (TextView) findViewById(R.id.result3);
        re0.setText("");
        re1.setText("");
        re2.setText("");
        re3.setText("");
        c.setViews(re0, re1, re2, re3);
    }

    public void resetCalculator(View view) {
        System.out.println("[DEBUG] RESET CALCULATOR");
        initCalc();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initCalc();

    }

    public void onNumberClick(View view) {
        if (c.finished) {
            showToast("Can't input more numbers");
        }
        Button thisButton = (Button) view;
        Integer inputedNumber = Integer.parseInt((String) thisButton.getText());
        c.inputNumber(inputedNumber);

    }

    public void showToast(String errorText) {
        Context context = getApplicationContext();
        CharSequence text = errorText;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        try {
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            // Vibrate for 500 milliseconds
            v.vibrate(500);
        } catch (Exception e) {
            System.out.println("ERRROR" + e);
        }

    }

    public void onOperation(View view) {
        if (c.finished) {
            showToast("Can't input more operations");
        }
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

    }


}
