package com.example.mobileprogramming.course05.part02;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileprogramming.R;

public class Fragment02Activity extends AppCompatActivity {
    Fragment02MainFragment mainFragment;
    Fragment02MenuFragment menuFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_02);

        mainFragment = new Fragment02MainFragment();    // MainFragment 동적 생성
        getSupportFragmentManager().beginTransaction().replace(R.id.container, mainFragment).commit();
        menuFragment = new Fragment02MenuFragment();
    }

    public void onFragmentChanged(int index) {
        if (index == 0) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, menuFragment).commit();
        } else if (index == 1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, mainFragment).commit();
        }
    }
}
