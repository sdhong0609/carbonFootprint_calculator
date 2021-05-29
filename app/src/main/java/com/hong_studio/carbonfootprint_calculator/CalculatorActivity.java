package com.hong_studio.carbonfootprint_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    RadioGroup rg;
    TextView tv, tv_erase;
    EditText et01, et02, et03, et04;
    RadioButton rb01, rb02, rb03, rb04;
    TextView tv_gasoline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        rg= findViewById(R.id.rg);
        tv= findViewById(R.id.tv_gasoline);
        et01= findViewById(R.id.ed01);
        et02= findViewById(R.id.ed02);
        et03= findViewById(R.id.ed03);
        et04= findViewById(R.id.ed04);
        tv_erase= findViewById(R.id.tv_erase);
        rb01= findViewById(R.id.rb01);
        rb02= findViewById(R.id.rb02);
        rb03= findViewById(R.id.rb03);
        rb04= findViewById(R.id.rb04);
        tv_gasoline= findViewById(R.id.tv_gasoline);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb=findViewById(checkedId);
                if(rb==rb04){
                    tv.setText("사용량 없음");
                    et04.setVisibility(View.GONE);
                    tv_erase.setText("");
                } else{
                    tv.setText(rb.getText().toString()+" 사용량");
                    et04.setVisibility(View.VISIBLE);
                    tv_erase.setText("km/월");
                }
            }
        });
    }

    public void btnResult(View view) {

        int num1=0;
        int num2=0;
        int num3=0;
        try{
            num1= Integer.parseInt(et01.getText().toString());
            num2= Integer.parseInt(et02.getText().toString());
            num3= Integer.parseInt(et03.getText().toString());
        } catch(Exception e){
            num1=0;
            num2=0;
            num3=0;
        }

        Intent intent= new Intent(this, ResultActivity.class);
        intent.putExtra("num1", num1);
        intent.putExtra("num2", num2);
        intent.putExtra("num3", num3);

        int rbId= rg.getCheckedRadioButtonId();

        int num4_1=0;
        int num4_2=0;
        int num4_3=0;

        try{
            switch (rbId){
                case R.id.rb01:
                    num4_1= Integer.parseInt(et04.getText().toString());
                    intent.putExtra("num4_1", num4_1);
                    break;

                case R.id.rb02:
                    num4_2= Integer.parseInt(et04.getText().toString());
                    intent.putExtra("num4_2", num4_2);
                    break;

                case R.id.rb03:
                    num4_3= Integer.parseInt(et04.getText().toString());
                    intent.putExtra("num4_3", num4_3);
                    break;

                case R.id.rb04:
                    break;
            }

        } catch (Exception e){
            num4_1=0;
            num4_2=0;
            num4_3=0;
        }

        startActivity(intent);
        finish();
    }

    public void btnReset(View view) {
        et01.setText("");
        et02.setText("");
        et03.setText("");
        et04.setText("");
    }
}