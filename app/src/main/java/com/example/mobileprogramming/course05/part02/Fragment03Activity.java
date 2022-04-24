package com.example.mobileprogramming.course05.part02;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileprogramming.R;

public class Fragment03Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_03);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
