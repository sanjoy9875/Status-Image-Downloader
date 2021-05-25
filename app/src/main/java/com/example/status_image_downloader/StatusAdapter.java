package com.example.status_image_downloader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StatusAdapter extends RecyclerView.Adapter<StatusViewHolder> {

    private Context context;
    private ArrayList<Object> statusList;

    public StatusAdapter(Context context, ArrayList<Object> statusList) {
        this.context = context;
        this.statusList = statusList;
    }

    @NonNull
    @Override
    public StatusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(context).inflate(R.layout.item_layout,null,false);
        return new StatusViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StatusViewHolder holder, int position) {

        final StatusModel model = (StatusModel) statusList.get(position);

       holder.setData(model);

    }

    @Override
    public int getItemCount() {
        return statusList.size();
    }
}
