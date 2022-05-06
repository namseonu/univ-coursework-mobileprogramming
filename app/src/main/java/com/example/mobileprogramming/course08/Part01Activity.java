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
import com.example.mobileprogramming.course08.part01.InternalStorageActivity;
import com.example.mobileprogramming.course08.part01.SharedPreferencesActivity;

import java.util.ArrayList;

public class Part01Activity extends AppCompatActivity {
    private final ArrayList<String> courseContentList = new ArrayList<>();
    private final String tag = "ACT/COURSE08-01";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_08_01);

        initCourseContentList();
        initRecyclerView();
    }

    private void initCourseContentList() {
        courseContentList.add("Shared Preferences");
        courseContentList.add("Internal Storage");
    }

    private void initRecyclerView() {
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.course_08_01_recycler_view);
        CourseRecyclerViewAdapter mRecyclerViewAdpater = new CourseRecyclerViewAdapter();
        mRecyclerViewAdpater.setCourseContentList(courseContentList);

        // initialize click listener
        mRecyclerViewAdpater.setOnItemClickListener(new CourseRecyclerViewAdapter.onItemClickListener() {
            @Override
            public void onItemClick(View itemView, int itemPosition) {
                Intent intent = null;

                switch (itemPosition) {
                    case 0: // Shared Preferences
                        intent = new Intent(itemView.getContext(), SharedPreferencesActivity.class);
                        break;
                    case 1: // Internal Storage
                        intent = new Intent(itemView.getContext(), InternalStorageActivity.class);
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
