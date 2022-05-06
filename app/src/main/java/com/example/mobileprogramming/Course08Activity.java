package com.example.mobileprogramming;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.mobileprogramming.course08.Part01Activity;
import com.example.mobileprogramming.course08.Part02Activity;
import com.example.mobileprogramming.course08.Part03Activity;

import java.util.ArrayList;

public class Course08Activity extends AppCompatActivity {
    private final ArrayList<String> courseContentList = new ArrayList<>();
    private final String tag = "ACT/COURSE08";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_08);

        initClickListener();
    }

    private void initClickListener() {
        AppCompatButton part01 = (AppCompatButton) findViewById(R.id.course_08_01_btn);
        AppCompatButton part02 = (AppCompatButton) findViewById(R.id.course_08_02_btn);
        AppCompatButton part03 = (AppCompatButton) findViewById(R.id.course_08_03_btn);

        // 08-1. Data Persistency
        part01.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Part01Activity.class);
                startActivity(intent);
            }
        });

        // 08-2. SQLite (Database)
        part02.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Part02Activity.class);
                startActivity(intent);
            }
        });

        // 08-3. Data Networking
        part03.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Part03Activity.class);
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
