package com.example.mobileprogramming;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder> {
    private ArrayList<String> mWeekList;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_week, parent, false);
        return new ViewHolder(view, mItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MainRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.onBind(mWeekList.get(position));
    }

    @Override
    public int getItemCount() {
        return mWeekList.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setmWeekList(ArrayList<String> mWeekList) {
        this.mWeekList = mWeekList;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatButton button;

        public ViewHolder(@NonNull View itemView, final onItemClickListener mItemClickListener) {
            super(itemView);
            button = (AppCompatButton) itemView.findViewById(R.id.item_week_btn);

            itemView.findViewById(R.id.item_week_btn).setOnClickListener(new View.OnClickListener() {
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

        void onBind(String information) {
            button.setText(information);
        }
    }
}
