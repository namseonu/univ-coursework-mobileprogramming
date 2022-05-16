package com.example.mobileprogramming;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileprogramming.adapter.CourseRecyclerViewAdapter;
import com.example.mobileprogramming.course07.AsyncTaskDemoActivity;
import com.example.mobileprogramming.course07.UsingHandlerMessageActivity;
import com.example.mobileprogramming.course07.UsingHandlerRunnableObjectActivity;
import com.example.mobileprogramming.course07.UsingThreadActivity;

import java.util.ArrayList;

public class Course07Activity extends AppCompatActivity {
    private static final String TAG = "ACT/COURSE-07";
    private final ArrayList<String> courseContentList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_07);

        initCourseContentList();
        initRecyclerView();
    }

    private void initCourseContentList() {
        courseContentList.add("Using Thread at Android");
        courseContentList.add("Using Handler to access main thread (Messages)");
        courseContentList.add("Using Handler to access main thread (Runnable Objects)");
        courseContentList.add("AsyncTaskDemo");
    }

    private void initRecyclerView() {
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.course_07_recycler_view);
        CourseRecyclerViewAdapter mRecyclerViewAdpater = new CourseRecyclerViewAdapter();
        mRecyclerViewAdpater.setCourseContentList(courseContentList);

        // initialize click listener
        mRecyclerViewAdpater.setOnItemClickListener(new CourseRecyclerViewAdapter.onItemClickListener() {
            @Override
            public void onItemClick(View itemView, int itemPosition) {
                Intent intent = null;

                switch (itemPosition) {
                    case 0: // Using Thread at Android
                        intent = new Intent(itemView.getContext(), UsingThreadActivity.class);
                        break;
                    case 1: // Using Handler to access main thread (Messages)
                        intent = new Intent(itemView.getContext(), UsingHandlerMessageActivity.class);
                        break;
                    case 2: // Using Handler to access main thread (Runnable Objects)
                        intent = new Intent(itemView.getContext(), UsingHandlerRunnableObjectActivity.class);
                        break;
                    case 3: // AsyncTaskDemo
                        intent = new Intent(itemView.getContext(), AsyncTaskDemoActivity.class);
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
