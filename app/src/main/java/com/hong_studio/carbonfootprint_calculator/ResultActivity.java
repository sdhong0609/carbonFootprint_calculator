package com.hong_studio.carbonfootprint_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView tv_co2, tv_tree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tv_co2= findViewById(R.id.tv_co2);
        tv_tree= findViewById(R.id.tv_tree);

        Intent intent= getIntent();
        int num1= intent.getIntExtra("num1", 0);
        int num2= intent.getIntExtra("num2", 0);
        int num3= intent.getIntExtra("num3", 0);
        int num4_1= intent.getIntExtra("num4_1", 0);
        int num4_2= intent.getIntExtra("num4_2", 0);
        int num4_3= intent.getIntExtra("num4_3", 0);

        double co2Sum= num1*0.47 + num2*2.2 + num3*0.332 + num4_1*0.348 + num4_2*0.241 + num4_3*0.407;
        String s_co2= String.format("%.2f", co2Sum);
        String s_tree= String.format("%.2f", co2Sum/6.6);

        tv_co2.setText("CO²발생량\n"+ s_co2 +"kg");
        tv_tree.setText("필요 소나무\n"+ s_tree +"그루");
    }

    public void btnRestart(View view) {
        Intent intent= new Intent(this, IntroActivity.class);
        startActivity(intent);
        finish();
    }

    public void btnFinish(View view) {
        finish();
    }
}