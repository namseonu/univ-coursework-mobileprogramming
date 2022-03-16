package com.example.mobileprogramming.course03;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileprogramming.R;

public class TableLayoutExample1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_layout_example_1);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
