package com.example.mobileprogramming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.mobileprogramming.adapter.MainRecyclerViewAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final String tag = "ACT/MAIN";
    private final ArrayList<String> courseList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initCourseList();
        initRecyclerView();
    }

    private void initCourseList() {
        courseList.add("01. Introduction");
        courseList.add("02. Android Making First App");
        courseList.add("03. Views and Layouts");
        courseList.add("04. Application Basics Lifecycle Activty Intents");
        courseList.add("05. Widgets & Event");
        courseList.add("06. Graphics & Animation");
        courseList.add("07. Thread");
        courseList.add("08. Database");
    }

    private void initRecyclerView() {
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.main_week_recycler_view);
        MainRecyclerViewAdapter mRecyclerViewAdpater = new MainRecyclerViewAdapter();
        mRecyclerViewAdpater.setCourseList(courseList);

        // initialize click listener
        mRecyclerViewAdpater.setOnItemClickListener(new MainRecyclerViewAdapter.onItemClickListener() {
            @Override
            public void onItemClick(View itemView, int itemPosition) {
                Intent intent = null;

                switch(itemPosition) {
                    case 0:
                        intent = new Intent(itemView.getContext(), Course01Activity.class);
                        break;
                    case 1:
                        intent = new Intent(itemView.getContext(), Course02Activity.class);
                        break;
                    case 2:
                        intent = new Intent(itemView.getContext(), Course03Activity.class);
                        break;
                    case 3:
                        intent = new Intent(itemView.getContext(), Course04Activity.class);
                        break;
                    case 4:
                        intent = new Intent(itemView.getContext(), Course05Activity.class);
                        break;
                    case 5:
                        intent = new Intent(itemView.getContext(), Course06Activity.class);
                        break;
                    case 6:
                        intent = new Intent(itemView.getContext(), Course07Activity.class);
                        break;
                    case 7:
                        intent = new Intent(itemView.getContext(), Course08Activity.class);
                        break;
                    default:
                        Log.d(tag, "switch/default");
                        break;
                }

                // 액티비티 전환
                if(intent != null) startActivity(intent);
            }
        });

        mRecyclerView.setAdapter(mRecyclerViewAdpater);
    }
}