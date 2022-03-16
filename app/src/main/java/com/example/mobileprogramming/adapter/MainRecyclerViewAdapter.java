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

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder> {
    private ArrayList<String> courseList;
    private onItemClickListener mItemClickListener = null;

    public interface onItemClickListener {
        void onItemClick(View itemView, int itemPosition);
    }

    public void setOnItemClickListener(onItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    @NonNull
    @Override
    public MainRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_course, parent, false);
        return new ViewHolder(view, mItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MainRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.onBind(courseList.get(position));
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setCourseList(ArrayList<String> courseList) {
        this.courseList = courseList;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatButton button;

        public ViewHolder(@NonNull View itemView, final onItemClickListener mItemClickListener) {
            super(itemView);
            button = (AppCompatButton) itemView.findViewById(R.id.item_course_btn);

            itemView.findViewById(R.id.item_course_btn).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAbsoluteAdapterPosition();
                    Log.d("ADAPTER/MAIN", "ViewHolder/onClick");
                    if(position != RecyclerView.NO_POSITION) {
                        mItemClickListener.onItemClick(view, position);
                    }
                }
            });
        }

        void onBind(String course) {
            button.setText(course);
        }
    }
}
