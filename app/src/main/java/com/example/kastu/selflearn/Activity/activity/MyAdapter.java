package com.example.kastu.selflearn.Activity.activity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kastu.selflearn.Activity.model.ListItem;
import com.example.kastu.selflearn.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

   private List<ListItem> list;
   private Context context;

    public MyAdapter(List<ListItem> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {

        ListItem listItem = list.get(position);

        holder.textViewHead.setText(listItem.getHead());
        holder.textViewDesc.setText(listItem.getDesc());
        holder.likes.setText(String.valueOf(listItem.getLike()));
        holder.hates.setText(String.valueOf(listItem.getHate()));
        holder.loved.setText(String.valueOf(listItem.getLove()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewHead;
        public TextView textViewDesc;
        public TextView likes;
        public TextView hates;
        public TextView loved;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewHead= itemView.findViewById(R.id.textViewHead);
            textViewDesc= itemView.findViewById(R.id.textViewDesc);
            likes = itemView.findViewById(R.id.likes);
            hates= itemView.findViewById(R.id.hates);
            loved= itemView.findViewById(R.id.loved);
        }
    }
}
