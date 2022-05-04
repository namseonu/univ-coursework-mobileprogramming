package com.example.mobileprogramming;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileprogramming.adapter.CourseRecyclerViewAdapter;
import com.example.mobileprogramming.course03.LinearLayoutExample1bActivity;
import com.example.mobileprogramming.course06.CustomViewCircleActivity;
import com.example.mobileprogramming.course06.CustomViewRectangleActivity;
import com.example.mobileprogramming.course06.LayerListActivity;
import com.example.mobileprogramming.course06.MakingCustomViewActivity;
import com.example.mobileprogramming.course06.PaintStrokeCapAndJoinActivity;
import com.example.mobileprogramming.course06.PaintStyleActivity;
import com.example.mobileprogramming.course06.PathActivity;
import com.example.mobileprogramming.course06.StateListActivity;
import com.example.mobileprogramming.course06.TransitionDrawableActivity;

import java.util.ArrayList;

public class Course06Activity extends AppCompatActivity {
    private final ArrayList<String> courseContentList = new ArrayList<>();
    private final String tag = "ACT/COURSE06";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_06);

        initCourseContentList();
        initRecyclerView();
    }

    private void initCourseContentList() {
        courseContentList.add("Custom View - Circle");
        courseContentList.add("Custom View - Rectangle");
        courseContentList.add("Paint - Style");
        courseContentList.add("Paint - StrokeCap and StrokeJoin");
        courseContentList.add("Path");
        courseContentList.add("Making a Custom View");
        courseContentList.add("Layer List");
        courseContentList.add("Transition Drawable");
        courseContentList.add("State List");
    }

    private void initRecyclerView() {
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.course_06_recycler_view);
        CourseRecyclerViewAdapter mRecyclerViewAdpater = new CourseRecyclerViewAdapter();
        mRecyclerViewAdpater.setCourseContentList(courseContentList);

        // initialize click listener
        mRecyclerViewAdpater.setOnItemClickListener(new CourseRecyclerViewAdapter.onItemClickListener() {
            @Override
            public void onItemClick(View itemView, int itemPosition) {
                Intent intent = null;

                switch (itemPosition) {
                    case 0: // Custom View - Circle
                        intent = new Intent(itemView.getContext(), CustomViewCircleActivity.class);
                        break;
                    case 1: // Custom View - Rectangle
                        intent = new Intent(itemView.getContext(), CustomViewRectangleActivity.class);
                        break;
                    case 2: // Paint - Style
                        intent = new Intent(itemView.getContext(), PaintStyleActivity.class);
                        break;
                    case 3: // Paint - StrokeCap and StrokeJoin
                        intent = new Intent(itemView.getContext(), PaintStrokeCapAndJoinActivity.class);
                        break;
                    case 4: // Path
                        intent = new Intent(itemView.getContext(), PathActivity.class);
                        break;
                    case 5: // Making a custom view
                        intent = new Intent(itemView.getContext(), MakingCustomViewActivity.class);
                        break;
                    case 6: // Layer List
                        intent = new Intent(itemView.getContext(), LayerListActivity.class);
                        break;
                    case 7: // Transition Drawable
                        intent = new Intent(itemView.getContext(), TransitionDrawableActivity.class);
                        break;
                    case 8: // State List
                        intent = new Intent(itemView.getContext(), StateListActivity.class);
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
