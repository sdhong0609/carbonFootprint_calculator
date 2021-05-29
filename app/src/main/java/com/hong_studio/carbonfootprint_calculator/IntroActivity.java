package com.hong_studio.carbonfootprint_calculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
    }

    public void btnStart(View view) {
        Intent intent= new Intent(this, CalculatorActivity.class);
        startActivity(intent);
        finish();
    }

    public void btnCarbon(View view) {
        AlertDialog dialog= new AlertDialog.Builder(this).setTitle("탄소발자국이란?")
                            .setMessage("탄소발자국은 환경성적표지 환경영향 범주 중 하나로 제품 및 서비스의 " +
                            "원료채취, 생산, 수송·유통, 사용, 폐기 등 전 과정에서 발생하는 탄소(온실가스)가 " +
                            "기후변화에 미치는 영향을 계량적으로 나타낸 지표입니다").setPositiveButton("확인", null).create();

        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }
}