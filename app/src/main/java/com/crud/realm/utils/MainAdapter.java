package com.crud.realm.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<StudentModel> studentModels;

    public MainAdapter(Context context, ArrayList<StudentModel> studentModels) {
        this.context = context;
        this.studentModels = studentModels; // i am here
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
