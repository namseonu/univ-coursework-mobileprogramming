package com.example.mobileprogramming.course08;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileprogramming.R;
import com.example.mobileprogramming.adapter.CourseRecyclerViewAdapter;

import java.util.ArrayList;

public class Part03Activity extends AppCompatActivity {

    private final ArrayList<String> courseContentList = new ArrayList<>();
    private final String tag = "ACT/COURSE08-03";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_08_03);

        initCourseContentList();
        initRecyclerView();
    }

    private void initCourseContentList() {
    }

    private void initRecyclerView() {
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.course_08_03_recycler_view);
        CourseRecyclerViewAdapter mRecyclerViewAdpater = new CourseRecyclerViewAdapter();
        mRecyclerViewAdpater.setCourseContentList(courseContentList);

        // initialize click listener
        mRecyclerViewAdpater.setOnItemClickListener(new CourseRecyclerViewAdapter.onItemClickListener() {
            @Override
            public void onItemClick(View itemView, int itemPosition) {
                Intent intent = null;

                switch (itemPosition) {

                    default:
                        Log.d(tag, "switch/default");
                        break;
                }

                // 액티비티 전환
                if (intent != null) startActivity(intent);
            }
        });

        mRecyclerView.setAdapter(mRecyclerViewAdpater);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
