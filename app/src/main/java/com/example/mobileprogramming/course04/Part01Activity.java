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
import com.example.mobileprogramming.course04.part01.ExplicitIntentMainActivity;
import com.example.mobileprogramming.course04.part01.IntentActivity;
import com.example.mobileprogramming.course04.part01.ToastMainActivity;
import com.example.mobileprogramming.course04.part01.UnderstandingLayoutInflationActivity;

import java.util.ArrayList;

public class Part01Activity extends AppCompatActivity {
    private final ArrayList<String> courseContentList = new ArrayList<>();
    private final String tag = "ACT/COURSE04-01";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_04_01);

        initCourseContentList();
        initRecyclerView();
    }

    private void initCourseContentList() {
        courseContentList.add("Understanding Layout Inflation");
        courseContentList.add("Intent");
        courseContentList.add("Explicit Intent");
        courseContentList.add("Toast");
    }

    private void initRecyclerView() {
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.course_04_01_recycler_view);
        CourseRecyclerViewAdapter mRecyclerViewAdpater = new CourseRecyclerViewAdapter();
        mRecyclerViewAdpater.setCourseContentList(courseContentList);

        // initialize click listener
        mRecyclerViewAdpater.setOnItemClickListener(new CourseRecyclerViewAdapter.onItemClickListener() {
            @Override
            public void onItemClick(View itemView, int itemPosition) {
                Intent intent = null;

                switch (itemPosition) {
                    case 0: // Understanding Layout Inflation (p. 7~9)
                        intent = new Intent(itemView.getContext(), UnderstandingLayoutInflationActivity.class);
                        break;
                    case 1: // Intent - Exercise (p. 22~25)
                        intent = new Intent(itemView.getContext(), IntentActivity.class);
                        break;
                    case 2: // Explicit Intent - Exercises (p. 41~48)
                        intent = new Intent(itemView.getContext(), ExplicitIntentMainActivity.class);
                        break;
                    case 3: // Toast - Exercise (p. 53~55, startActivityForResult, onActivityResult)
                        intent = new Intent(itemView.getContext(), ToastMainActivity.class);
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
