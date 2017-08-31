package com.example.quantum.multiselectionrecyclerview;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pawneshwer on 8/31/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    private Context context;
    private List<MyData> list;
    private List<Integer> selectedIds = new ArrayList<>();

    public MyAdapter(Context context,List<MyData> list){
        this.context = context;
        this.list = list;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.adapter_item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        int id = list.get(position).getId();

        if (selectedIds.contains(id)){
            //set foreground color to FrameLayout.
            holder.rootView.setForeground(new ColorDrawable(ContextCompat.getColor(context,R.color.colorControlActivated)));
        }
        else {
            holder.rootView.setForeground(new ColorDrawable(ContextCompat.getColor(context,android.R.color.transparent)));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public MyData getItem(int position){
        return list.get(position);
    }

    public void setSelectedIds(List<Integer> selectedIds) {
        this.selectedIds = selectedIds;
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        FrameLayout rootView;
        MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            rootView = itemView.findViewById(R.id.root_view);
        }
    }
}
