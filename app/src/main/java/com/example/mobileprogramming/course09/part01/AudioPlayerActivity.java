package com.example.mobileprogramming.course09.part01;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileprogramming.R;

import java.io.IOException;

public class AudioPlayerActivity extends AppCompatActivity {

    String url = "http://sites.google.com/site/ubiaccessmobile/sample_audio.amr";   // Sample Audio

    MediaPlayer player;
    // 이미 구현된 기능을 사용, 반복할 변수를 미리 선언
    // Class 안에서 선언하였으므로 class 안에서 자유롭게 사용 가능

    int position;   // 일시정지된 위치를 저장

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_player);

        // #1. play button
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playAudio();
            }
        });

        // #2. Stop button
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAudio();
            }
        });

        // #3. Pause button
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pauseAudio();
            }
        });

        // #4. Restart button
        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restartAudio();
            }
        });
    }

    public void playAudio() {
        showToast("음악 파일 재생 호출됨");

        killPlayer();
        // 여러번 동작을 하려고 시도하였거나
        // 기존에 플레이어가 동작하고 있다면,
        // 객체 자체의 리소스를 해제

        player = new MediaPlayer();
        try {
            player.setDataSource(url);
            player.prepare();
            player.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopAudio() {
        showToast("음악 파일 재생 중지됨");

        if (player != null) {
            try {
                player.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pauseAudio() {
        showToast("음악 파일 재생 일시 중지됨");

        if (player != null) {
            try {
                position = player.getCurrentPosition();
                player.pause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void restartAudio() {
        showToast("음악 파일 재생이 다시 시작됨");

        if (player != null && !player.isPlaying()) {
            try {
                player.start();
                player.seekTo(position);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    public void killPlayer() {
        if (player != null) {
            try {
                player.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
