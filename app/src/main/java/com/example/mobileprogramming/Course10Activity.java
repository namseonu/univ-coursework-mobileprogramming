package com.example.mobileprogramming;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileprogramming.adapter.CourseRecyclerViewAdapter;
import com.example.mobileprogramming.course10.AllSensorsActivity;
import com.example.mobileprogramming.course10.GravitySensorActivity;

import java.util.ArrayList;

public class Course10Activity extends AppCompatActivity {
    private static final String TAG = "ACT/COURSE-10";
    private final ArrayList<String> courseContentList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_10);

        initCourseContentList();
        initRecyclerView();
    }

    private void initCourseContentList() {
        courseContentList.add("Gravity Sensor");
        courseContentList.add("All Sensors");
    }

    private void initRecyclerView() {
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.course_10_recycler_view);
        CourseRecyclerViewAdapter mRecyclerViewAdpater = new CourseRecyclerViewAdapter();
        mRecyclerViewAdpater.setCourseContentList(courseContentList);

        // initialize click listener
        mRecyclerViewAdpater.setOnItemClickListener(new CourseRecyclerViewAdapter.onItemClickListener() {
            @Override
            public void onItemClick(View itemView, int itemPosition) {
                Intent intent = null;

                switch (itemPosition) {
                    case 0: // Gravity Sensor
                        intent = new Intent(itemView.getContext(), GravitySensorActivity.class);
                        break;
                    case 1: // All Sensors
                        intent = new Intent(itemView.getContext(), AllSensorsActivity.class);
                        break;
                    default:
                        Log.d(TAG, "switch/default");
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
