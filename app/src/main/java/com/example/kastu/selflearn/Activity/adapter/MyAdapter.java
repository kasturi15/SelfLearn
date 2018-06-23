package com.example.kastu.selflearn.Activity.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kastu.selflearn.Activity.model.ListItem;
import com.example.kastu.selflearn.HorizontalScroll;
import com.example.kastu.selflearn.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

   private List<ListItem> list;
   private Context context;
   private Activity activity;

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

        String[] imageUrls = new String[]{
                "https://picsum.photos/301/300/",
                "https://lorempixel.com/302/300/",
                "https://lorempixel.com/303/300/",
                "https://picsum.photos/304/300/",
                "https://lorempixel.com/305/300/",
                "https://lorempixel.com/306/300/"
        };

        holder.textViewHead.setText(listItem.getHead());
        holder.textViewDesc.setText(listItem.getDesc());
        holder.likes.setText(String.valueOf(listItem.getLike()));
        holder.hates.setText(String.valueOf(listItem.getHate()));
        holder.loved.setText(String.valueOf(listItem.getLove()));

        HorizontalScrollView horizontalScroll = holder.horizontalScroll;
        LinearLayout scroll = holder.scroll;

        /*ViewPager viewPager = holder.viewPager;
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(context,imageUrls);
        viewPager.setAdapter(viewPagerAdapter);*/

        LayoutInflater inflater = LayoutInflater.from(context);

        for (int i = 0; i < imageUrls.length; i++)
        {
            View view = inflater.inflate(R.layout.item,scroll,false);

            ImageView imageView2 = view.findViewById(R.id.imageView2);
            Picasso.get()
                    .load(imageUrls[i])
                    .fit()
                    .into(imageView2);

            scroll.addView(view);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewHead;
        public TextView textViewDesc;
        public ImageView imageurl;
        public ViewPager viewPager;
        public HorizontalScrollView horizontalScroll;
        public TextView likes;
        public TextView hates;
        public TextView loved;
        public LinearLayout scroll;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewHead= itemView.findViewById(R.id.textViewHead);
            textViewDesc= itemView.findViewById(R.id.textViewDesc);
           // viewPager = itemView.findViewById(R.id.viewPager);
            horizontalScroll= itemView.findViewById(R.id.horizontalScroll);
            scroll = itemView.findViewById(R.id.scroll);
            imageurl = itemView.findViewById(R.id.image);
            likes = itemView.findViewById(R.id.likes);
            hates= itemView.findViewById(R.id.hates);
            loved= itemView.findViewById(R.id.loved);
        }
    }
}
