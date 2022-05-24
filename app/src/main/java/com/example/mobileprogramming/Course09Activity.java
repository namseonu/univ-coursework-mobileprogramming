package com.example.mobileprogramming;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.mobileprogramming.course09.Part01Activity;
import com.example.mobileprogramming.course09.Part02Activity;

import java.util.ArrayList;

public class Course09Activity extends AppCompatActivity {
    private final ArrayList<String> courseContentList = new ArrayList<>();
    private final String tag = "ACT/COURSE09";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_09);

        initClickListener();
    }

    private void initClickListener() {
        AppCompatButton part01 = (AppCompatButton) findViewById(R.id.course_09_01_btn);
        AppCompatButton part02 = (AppCompatButton) findViewById(R.id.course_09_02_btn);

        // 09-1. Multimedia
        part01.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Part01Activity.class);
                startActivity(intent);
            }
        });

        // 09-2. Location based Service
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
