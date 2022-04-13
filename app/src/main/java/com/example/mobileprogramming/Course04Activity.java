package com.example.mobileprogramming;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileprogramming.adapter.CourseRecyclerViewAdapter;
import com.example.mobileprogramming.course03.FrameLayoutExampleActivity;
import com.example.mobileprogramming.course03.LinearLayoutExample1bActivity;
import com.example.mobileprogramming.course03.LinearLayoutExample1cActivity;
import com.example.mobileprogramming.course03.LinearLayoutExample2aActivity;
import com.example.mobileprogramming.course03.LinearLayoutGravityActivity;
import com.example.mobileprogramming.course03.LinearLayoutWeightActivity;
import com.example.mobileprogramming.course03.RelativeLayoutExampleActivity;
import com.example.mobileprogramming.course03.ScrollViewExample1Activity;
import com.example.mobileprogramming.course03.ScrollViewExample2Activity;
import com.example.mobileprogramming.course03.TableLayoutExample1Activity;
import com.example.mobileprogramming.course03.TableLayoutExample2Activity;
import com.example.mobileprogramming.course03.TableLayoutExample3Activity;

import java.util.ArrayList;

public class Course04Activity extends AppCompatActivity {
    private final ArrayList<String> courseContentList = new ArrayList<>();
    private final String tag = "ACT/COURSE04";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_04);

        initCourseContentList();
        initRecyclerView();
    }

    private void initCourseContentList() {
    }

    private void initRecyclerView() {
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.course_04_recycler_view);
        CourseRecyclerViewAdapter mRecyclerViewAdpater = new CourseRecyclerViewAdapter();
        mRecyclerViewAdpater.setCourseContentList(courseContentList);


        mRecyclerView.setAdapter(mRecyclerViewAdpater);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
