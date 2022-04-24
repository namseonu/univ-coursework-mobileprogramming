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
import com.example.mobileprogramming.course05.part02.Fragment01Activity;
import com.example.mobileprogramming.course05.part02.Fragment02Activity;
import com.example.mobileprogramming.course05.part02.Fragment03Activity;
import com.example.mobileprogramming.course05.part02.ListViewActivity;
import com.example.mobileprogramming.course05.part02.SpinnerActivity;
import com.example.mobileprogramming.course05.part02.WebView01Activity;
import com.example.mobileprogramming.course05.part02.WebView02Activity;

import java.util.ArrayList;

public class Part02Activity extends AppCompatActivity {
    private final ArrayList<String> courseContentList = new ArrayList<>();
    private final String tag = "ACT/COURSE05-02";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_05_02);

        initCourseContentList();
        initRecyclerView();
    }

    private void initCourseContentList() {
        courseContentList.add("Fragment - Exercise (p. 6~10)");
        courseContentList.add("Fragment - Exercise (p. 13~19)");
        courseContentList.add("Fragment - Exercise (p. 26~31)");
        courseContentList.add("WebView - Exercise (p. 34~38)");
        courseContentList.add("WebView - Exercise (p. 39~40)");
        courseContentList.add("ListView - Exercise (p. 47~49)");
        courseContentList.add("Spinner - Exercise (p. 52~54)");
    }

    private void initRecyclerView() {
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.course_05_02_recycler_view);
        CourseRecyclerViewAdapter mRecyclerViewAdpater = new CourseRecyclerViewAdapter();
        mRecyclerViewAdpater.setCourseContentList(courseContentList);

        // initialize click listener
        mRecyclerViewAdpater.setOnItemClickListener(new CourseRecyclerViewAdapter.onItemClickListener() {
            @Override
            public void onItemClick(View itemView, int itemPosition) {
                Intent intent = null;

                switch (itemPosition) {
                    case 0: // Fragment - Exercise (p. 6~10)
                        intent = new Intent(itemView.getContext(), Fragment01Activity.class);
                        break;
                    case 1: // Fragment - Exericse (p. 13~19)
                        intent = new Intent(itemView.getContext(), Fragment02Activity.class);
                        break;
                    case 2: // Fragment - Exericse (p. 26~31)
                        intent = new Intent(itemView.getContext(), Fragment03Activity.class);
                        break;
                    case 3: // WebView - Exercise (p. 34~38)
                        intent = new Intent(itemView.getContext(), WebView01Activity.class);
                        break;
                    case 4: // WebView - Exercise (p. 39~40)
                        intent = new Intent(itemView.getContext(), WebView02Activity.class);
                        break;
                    case 5: // ListView - Exercise (p. 47~49)
                        intent = new Intent(itemView.getContext(), ListViewActivity.class);
                        break;
                    case 6: // Spinner - Exercise (p. 52~54)
                        intent = new Intent(itemView.getContext(), SpinnerActivity.class);
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
