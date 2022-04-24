package com.example.mobileprogramming.course04.part02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileprogramming.R;

public class MyServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_service);

        Button btnStart = findViewById(R.id.btnStartService);
        btnStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startService(new Intent(getApplicationContext(), MyService.class));
            }
        });

        Button btnStop = findViewById(R.id.btnStopService);
        btnStop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                stopService(new Intent(getApplicationContext(), MyService.class));
            }
        });
    }
}
