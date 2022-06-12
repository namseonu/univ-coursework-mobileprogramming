package com.example.mobileprogramming.course09.part01;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileprogramming.R;

public class VideoPlayerActivity extends AppCompatActivity {

    VideoView videoView;
    String url = "http://sites.google.com/site/ubiaccessmobile/sample_video.mp4";   // 이미 인터넷에 올라가 있는 영상 확인 가능

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        videoView = findViewById(R.id.videoView);

        // video를 동작시키기 위해 MediaController 객체를 하나 생성한다.
        MediaController mc = new MediaController(this);
        videoView.setMediaController(mc);
        // videoView에 controller가 한 개 들어갔으므로 controller에 동작할 수 있는 기능 구현 가능

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo();
            }
        });
    }

    public void playVideo() {
        videoView.setVideoURI(Uri.parse(url));  // 1. URL 입력 받아오기
        videoView.requestFocus();               // 2. 사용할 수 있는지 requestFocus()
        videoView.start();                      // 3. start()를 통해 재생
    }
}
