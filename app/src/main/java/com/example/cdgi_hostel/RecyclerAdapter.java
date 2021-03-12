package com.example.cdgi_hostel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    List<Model> itemList;

    public RecyclerAdapter(List<Model> itemList) {
        this.itemList=itemList;

    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
            holder.image.setImageResource(itemList.get(position).getImage());
            holder.studentName.setText(itemList.get(position).getStudentName());
            holder.time.setText(itemList.get(position).getTime());
            holder.rolNumber.setText(itemList.get(position).getRollNumber());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView studentName,time,rolNumber;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.imageView);
            studentName = itemView.findViewById(R.id.studentName);
            time = itemView.findViewById(R.id.time);
            rolNumber = itemView.findViewById(R.id.rollNumber);

        }
    }
}
