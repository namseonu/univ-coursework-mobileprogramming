package com.example.mobileprogramming.course05;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileprogramming.R;
import com.example.mobileprogramming.adapter.CourseRecyclerViewAdapter;
import com.example.mobileprogramming.course05.part01.CheckBoxActivity;
import com.example.mobileprogramming.course05.part01.EditTextActivity;
import com.example.mobileprogramming.course05.part01.EventListenerActivity;
import com.example.mobileprogramming.course05.part01.MenuActivity;
import com.example.mobileprogramming.course05.part01.RadioButtonActivity;

import java.util.ArrayList;

public class Part01Activity extends AppCompatActivity {
    private final ArrayList<String> courseContentList = new ArrayList<>();
    private final String tag = "ACT/COURSE05-01";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_05_01);

        initCourseContentList();
        initRecyclerView();
    }

    private void initCourseContentList() {
        courseContentList.add("Event Listener");
        courseContentList.add("EditText");
        courseContentList.add("CheckBox");
        courseContentList.add("RadioButton");
        courseContentList.add("Menu - Handling click events");
    }

    private void initRecyclerView() {
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.course_05_01_recycler_view);
        CourseRecyclerViewAdapter mRecyclerViewAdpater = new CourseRecyclerViewAdapter();
        mRecyclerViewAdpater.setCourseContentList(courseContentList);

        // initialize click listener
        mRecyclerViewAdpater.setOnItemClickListener(new CourseRecyclerViewAdapter.onItemClickListener() {
            @Override
            public void onItemClick(View itemView, int itemPosition) {
                Intent intent = null;

                switch (itemPosition) {
                    case 0: // Event Listener
                        intent = new Intent(itemView.getContext(), EventListenerActivity.class);
                        break;
                    case 1: // EditText
                        intent = new Intent(itemView.getContext(), EditTextActivity.class);
                        break;
                    case 2: // CheckBox
                        intent = new Intent(itemView.getContext(), CheckBoxActivity.class);
                        break;
                    case 3: // RadioButton
                        intent = new Intent(itemView.getContext(), RadioButtonActivity.class);
                        break;
                    case 4: // Menu - Handling click events
                        intent = new Intent(itemView.getContext(), MenuActivity.class);
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
