package com.crud.realm.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.crud.realm.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<StudentModel> studentModel;

    public MainAdapter(Context context, ArrayList<StudentModel> studentModels) {
        this.context = context;
        this.studentModel = studentModels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.main_list, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.studentName.setText(studentModel.get(position).getStudentName());
        holder.studentAddress.setText(studentModel.get(position).getStudentAddress());

    }

    @Override
    public int getItemCount() {
        return studentModel.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView studentName, studentAddress;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            studentName     = itemView.findViewById(R.id.student_name);
            studentAddress  = itemView.findViewById(R.id.student_address);
        }
    }
}
