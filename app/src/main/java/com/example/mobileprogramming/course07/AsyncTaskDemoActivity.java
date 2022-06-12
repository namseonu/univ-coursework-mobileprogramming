package com.example.mobileprogramming.course07;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileprogramming.R;

public class AsyncTaskDemoActivity extends AppCompatActivity {
    TextView tvCounter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_demo);
        tvCounter = (TextView) findViewById(R.id.tv_counter);

        new CountDownTask().execute();  // Starts the CountDownTask
    }

    private class CountDownTask extends AsyncTask<Void, Integer, Void> {

        @Override
        protected void onPreExecute() {
            tvCounter.setText("*START*");
        }

        @Override
        protected Void doInBackground(Void... voids) {
            for(int i = 15; i >= 0; i--) {
                try {
                    Thread.sleep(1000);
                    publishProgress(i); // Invokes onProgressUpdate();
                } catch (Exception e) {}
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            tvCounter.setText(Integer.toString(values[0].intValue()));
        }

        @Override
        protected void onPostExecute(Void unused) {
            tvCounter.setText("*DONE*");
        }
    }
}
