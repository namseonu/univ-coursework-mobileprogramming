package com.example.mobileprogramming.course07;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileprogramming.R;

public class UsingHandlerMessageActivity extends AppCompatActivity {
    TextView textView0;
    ProgressBar bar;
    ProgressHandler handler;
    boolean isRunning = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_using_handler_message);
        textView0 = (TextView) findViewById(R.id.TextView01);
        bar = (ProgressBar) findViewById(R.id.progress);

        // ProgressHandler 객체 생성 (handler)
        handler = new ProgressHandler();
    }

    @Override
    protected void onStart() {
        super.onStart();
        bar.setProgress(0);

        // Worker thread
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i = 0; i < 20 && isRunning; i++) {
                        Thread.sleep(1000);
                        Message msg = handler.obtainMessage();
                        handler.sendMessage(msg);
                    }
                } catch (Exception ex) {
                    Log.e("MainActivity", "Exception in processing message.", ex);
                }
            }
        });

        isRunning = true;
        thread1.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        isRunning = false;
    }

    // ProgressHandler (handler class)
    // Handler를 상속받은 클래스
    public class ProgressHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            bar.incrementProgressBy(5);

            if(bar.getProgress() == bar.getMax()) {
                textView0.setText("Done");
            } else {
                textView0.setText("Working..." + bar.getProgress());
            }
        }
    }
}
