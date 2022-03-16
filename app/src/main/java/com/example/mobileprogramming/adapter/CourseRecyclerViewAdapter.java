package com.example.mobileprogramming.adapter;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileprogramming.R;

import java.util.ArrayList;

public class CourseRecyclerViewAdapter extends RecyclerView.Adapter<CourseRecyclerViewAdapter.ViewHolder> {
    private ArrayList<String> courseContentList;
    private onItemClickListener mItemClickListener = null;

    public interface onItemClickListener {
        void onItemClick(View itemView, int itemPosition);
    }

    public void setOnItemClickListener(onItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_course_content, parent, false);
        return new ViewHolder(view, mItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(courseContentList.get(position));
    }

    @Override
    public int getItemCount() {
        return courseContentList.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setCourseContentList(ArrayList<String> courseContentList) {
        this.courseContentList = courseContentList;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatButton button;

        public ViewHolder(@NonNull View itemView, onItemClickListener mItemClickListener) {
            super(itemView);
            button = (AppCompatButton) itemView.findViewById(R.id.item_course_content_btn);

            itemView.findViewById(R.id.item_course_content_btn).setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    int position = getAbsoluteAdapterPosition();
                    Log.d("ADAPTER/COURSE02", "ViewHolder/onClick");
                    if(position != RecyclerView.NO_POSITION) {
                        mItemClickListener.onItemClick(view, position);
                    }
                }
            });
        }

        void onBind(String courseContent) { button.setText(courseContent); }
    }
}
