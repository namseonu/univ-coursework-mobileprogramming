package com.example.mobileprogramming.course06;

import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileprogramming.R;

public class TransitionDrawableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_drawable);

        ImageButton button = (ImageButton) findViewById(R.id.button);
        TransitionDrawable drawable = (TransitionDrawable) button.getDrawable();
        drawable.startTransition(5000);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
