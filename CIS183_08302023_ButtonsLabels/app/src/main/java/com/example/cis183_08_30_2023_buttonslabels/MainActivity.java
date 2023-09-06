package com.example.cis183_08_30_2023_buttonslabels;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button   btn_j_increase;
    Button   btn_j_decrease;
    Button   btn_j_double;
    Button   btn_j_reset;
    TextView tv_j_fontSize;
    TextView tv_j_greeting;
    int currentTextSize = 12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting variables to be correlated with what's on the layout
        btn_j_increase = findViewById(R.id.btn_v_increase);
        btn_j_decrease = findViewById(R.id.btn_v_decrease);
        btn_j_double   = findViewById(R.id.btn_v_double);
        btn_j_reset    = findViewById(R.id.btn_v_reset);
        tv_j_fontSize  = findViewById(R.id.tv_v_textSize);
        tv_j_greeting  = findViewById(R.id.tv_v_greeting);

        tv_j_greeting.setText("Hello Nick!");

        setButtonIncreaseListener();
        setButtonDecreaseListener();
        setButtonDoubleListener();
        setButtonResetListener();
    }

    public void setButtonIncreaseListener()
    {
        btn_j_increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("======","Button Increase Pressed!!");

                changeSize(1);
            }
        });
    }

    public void setButtonDecreaseListener()
    {
        btn_j_decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("======","Button Decrease Pressed!!");

                changeSize(-1);
            }
        });
    }

    public void setButtonDoubleListener()
    {
        btn_j_double.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("======","Button Double Pressed!!");

                changeSize(currentTextSize);
            }
        });
    }

    public void setButtonResetListener()
    {
        btn_j_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("======","Button Reset Pressed!!");

                changeSize(-currentTextSize+12);
            }
        });
    }

    public void changeSize(int amount)
    {

        currentTextSize = currentTextSize + amount;
        //Instead of this solution, setting the textSize could be done by (currentTextSize + "")
        String curSize = String.valueOf(currentTextSize);
        tv_j_fontSize.setText(curSize);
        tv_j_greeting.setTextSize(currentTextSize);
    }
}