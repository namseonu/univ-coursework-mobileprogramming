package com.example.mobileprogramming.course04.part01;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileprogramming.R;

public class UnderstandingLayoutInflationActivity extends AppCompatActivity {
    LinearLayout container;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_understanding_layout_inflation);

        container = (LinearLayout) findViewById(R.id.container);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                // attachToRoot
                // --> true: child view를 parent view에 지금 즉시 붙이겠다.
                // --> false: chlid view를 parent view에 지금 붙이지 않고, addView 등을 이용해 붙이겠다.
                // 이때, fragment의 경우 true 값을 줘버리면 이후 트랜잭션 수행 시 IllegalStateException이 발생할 수 있으므로 false로 해야 한다.
                inflater.inflate(R.layout.layout_sub_1, container, true);

                CheckBox checkBox = (CheckBox) container.findViewById(R.id.checkBox);
                checkBox.setText("로딩되었어요.");
            }
        });
    }
}
