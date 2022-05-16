package com.example.mobileprogramming.course07;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileprogramming.R;

public class UsingThreadActivity extends AppCompatActivity {

    private boolean running;
    private int value;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_using_thread);

        final TextView textview = (TextView) findViewById(R.id.textView01);
        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                textview.setText("스레드에서 받은 값: " + value);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        running = true;
        Thread thread1 = new BackgroundThread();
        thread1.start();
    }

    @Override
    protected void onPause() {
        super.onPause();

        running = false;
        value = 0;
    }

    class BackgroundThread extends Thread {
        @Override
        public void run() {
            while (running) {
                try {
                    Thread.sleep(1000);
                    value++;
                } catch (Exception ex) {
                }
            }
        }
    }
}
