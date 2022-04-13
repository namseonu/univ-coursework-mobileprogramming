package com.example.mobileprogramming;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.mobileprogramming.course05.Part01Activity;
import com.example.mobileprogramming.course05.Part02Activity;

import java.util.ArrayList;

public class Course05Activity extends AppCompatActivity {
    private final ArrayList<String> courseContentList = new ArrayList<>();
    private final String tag = "ACT/COURSE05";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_05);

        initClickListener();
    }

    private void initClickListener() {
        AppCompatButton part01 = (AppCompatButton) findViewById(R.id.course_05_01_btn);
        AppCompatButton part02 = (AppCompatButton) findViewById(R.id.course_05_02_btn);

        // 05-1. Basic
        part01.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Part01Activity.class);
                startActivity(intent);
            }
        });

        // 05-2. Advanced
        part02.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Part02Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
