package com.example.mobileprogramming.course04;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileprogramming.R;
import com.example.mobileprogramming.adapter.CourseRecyclerViewAdapter;
import com.example.mobileprogramming.course04.part02.LifeCycleActivity;
import com.example.mobileprogramming.course04.part02.MyServiceActivity;

import java.util.ArrayList;

public class Part02Activity extends AppCompatActivity {
    private final ArrayList<String> courseContentList = new ArrayList<>();
    private final String tag = "ACT/COURSE04-02";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_04_02);

        initCourseContentList();
        initRecyclerView();
    }

    private void initCourseContentList() {
        courseContentList.add("The Life Cycle of an Activity");
        courseContentList.add("Service");
    }

    private void initRecyclerView() {
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.course_04_02_recycler_view);
        CourseRecyclerViewAdapter mRecyclerViewAdpater = new CourseRecyclerViewAdapter();
        mRecyclerViewAdpater.setCourseContentList(courseContentList);

        // initialize click listener
        mRecyclerViewAdpater.setOnItemClickListener(new CourseRecyclerViewAdapter.onItemClickListener() {
            @Override
            public void onItemClick(View itemView, int itemPosition) {
                Intent intent = null;

                switch (itemPosition) {
                    case 0: // The Life Cycle of an Activity
                        intent = new Intent(itemView.getContext(), LifeCycleActivity.class);
                        break;
                    case 1: // Service
                        intent = new Intent(itemView.getContext(), MyServiceActivity.class);
                        break;
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
