package com.example.mobileprogramming.course06;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileprogramming.R;

public class AnimationTransparentActivity extends AppCompatActivity {
    ImageView imageView1;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        imageView1 = (ImageView) findViewById(R.id.imageView1);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Animation anim = AnimationUtils.loadAnimation(
                        getApplicationContext(), R.anim.transparent);
                imageView1.startAnimation(anim);
                editText.append("애니메이션시작됨.\n");
            }
        });
    }
}
