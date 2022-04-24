package com.example.mobileprogramming.course04.part02;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileprogramming.R;

public class LifeCycleActivity extends AppCompatActivity {
    String tag = "LifeCycle";
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        Log.d(tag, "In the onCreate() event");
        Toast.makeText(getApplicationContext(), "onCreate()", Toast.LENGTH_SHORT).show();
    }

    public void onStart() {
        super.onStart();
        Log.d(tag, "In the onStart() event");
        Toast.makeText(getApplicationContext(), "onStart()", Toast.LENGTH_SHORT).show();
    }

    public void onRestart() {
        super.onRestart();
        Log.d(tag, "In the onRestart() event");
        Toast.makeText(getApplicationContext(), "onRestart()", Toast.LENGTH_SHORT).show();
    }

    public void onResume() {
        super.onResume();
        Log.d(tag, "In the onResume() event");
        Toast.makeText(getApplicationContext(), "onResume()", Toast.LENGTH_SHORT).show();
    }

    public void onPause() {
        super.onPause();
        Log.d(tag, "In the onPause() event");
        Toast.makeText(getApplicationContext(), "onPause()", Toast.LENGTH_SHORT).show();
    }

    public void onStop() {
        super.onStop();
        Log.d(tag, "In the onStop() event");
        Toast.makeText(getApplicationContext(), "onStop()", Toast.LENGTH_SHORT).show();
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d(tag, "In the onDestroy() event");
        Toast.makeText(getApplicationContext(), "onDestroy()", Toast.LENGTH_SHORT).show();
    }
}
