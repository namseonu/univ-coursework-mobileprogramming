package com.example.mobileprogramming;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileprogramming.adapter.CourseRecyclerViewAdapter;
import com.example.mobileprogramming.course03.*;

import java.util.ArrayList;

public class Course03Activity extends AppCompatActivity {
    private final ArrayList<String> courseContentList = new ArrayList<>();
    private final String tag = "ACT/COURSE03";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_03);

        initCourseContentList();
        initRecyclerView();
    }

    private void initCourseContentList() {
        courseContentList.add("LinearLayout - Example 1b");
        courseContentList.add("LinearLayout - Example 1c");
        courseContentList.add("LinearLayout - Example 2a (Fill Mode)");
        courseContentList.add("LinearLayout - Weight");
        courseContentList.add("LinearLayout - Gravity");
        courseContentList.add("LinearLayout - Padding and Margin");
        courseContentList.add("RelativeLayout - Example");
        courseContentList.add("FrameLayout - Example");
        courseContentList.add("TableLayout - Example 1");
        courseContentList.add("TableLayout - Example 2");
        courseContentList.add("TableLayout - Example 3");
        courseContentList.add("ScrollView - Example 1");
        courseContentList.add("ScrollView - Example 2");
    }

    private void initRecyclerView() {
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.course_03_recycler_view);
        CourseRecyclerViewAdapter mRecyclerViewAdpater = new CourseRecyclerViewAdapter();
        mRecyclerViewAdpater.setCourseContentList(courseContentList);

        // initialize click listener
        mRecyclerViewAdpater.setOnItemClickListener(new CourseRecyclerViewAdapter.onItemClickListener() {
            @Override
            public void onItemClick(View itemView, int itemPosition) {
                Intent intent = null;

                switch (itemPosition) {
                    case 0: // LinearLayout - Example 1b
                        intent = new Intent(itemView.getContext(), LinearLayoutExample1bActivity.class);
                        break;
                    case 1: // LinearLayout - Example 1c
                        intent = new Intent(itemView.getContext(), LinearLayoutExample1cActivity.class);
                        break;
                    case 2: // LinearLayout - Example 2a (Fill Mode)
                        intent = new Intent(itemView.getContext(), LinearLayoutExample2aActivity.class);
                        break;
                    case 3: // LinearLayout - Weight
                        intent = new Intent(itemView.getContext(), LinearLayoutWeightActivity.class);
                        break;
                    case 4: // LinearLayout - Gravity
                        intent = new Intent(itemView.getContext(), LinearLayoutGravityActivity.class);
                        break;
                    case 5: // LinearLayout - Padding and Margin
                        intent = new Intent(itemView.getContext(), LinearLayoutPaddingMarginActivity.class);
                        break;
                    case 6: // RelativeLayout - Example
                        intent = new Intent(itemView.getContext(), RelativeLayoutExampleActivity.class);
                        break;
                    case 7: // FrameLayout - Example
                        intent = new Intent(itemView.getContext(), FrameLayoutExampleActivity.class);
                        break;
                    case 8: // TableLayout - Example 1
                        intent = new Intent(itemView.getContext(), TableLayoutExample1Activity.class);
                        break;
                    case 9: // TableLayout - Example 2
                        intent = new Intent(itemView.getContext(), TableLayoutExample2Activity.class);
                        break;
                    case 10:    // TableLayout - Example 3
                        intent = new Intent(itemView.getContext(), TableLayoutExample3Activity.class);
                        break;
                    case 11:    // ScrollView - Example 1
                        intent = new Intent(itemView.getContext(), ScrollViewExample1Activity.class);
                        break;
                    case 12:    // ScrollView - Example 2
                        intent = new Intent(itemView.getContext(), ScrollViewExample2Activity.class);
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
