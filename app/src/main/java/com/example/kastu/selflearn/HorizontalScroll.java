package com.example.kastu.selflearn;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

public class HorizontalScroll extends AppCompatActivity {

    private Context context;
    private String[] imageUrls;

    public HorizontalScroll(Context context, String[] imageUrls){
        this.context = context;
        this.imageUrls =imageUrls;
    }

    public HorizontalScroll(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_scroll);

       LinearLayout scroll = findViewById(R.id.scroll);

        /*String[] imageUrls = new String[]{
                "http://lorempixel.com/300/300/",
                "http://lorempixel.com/300/300/",
                "http://lorempixel.com/300/300/",
                "http://lorempixel.com/300/300/",
                "http://lorempixel.com/300/300/",
                "http://lorempixel.com/300/300/"
        };*/

        LayoutInflater inflater = LayoutInflater.from(this);

        for (int i = 0; i <= imageUrls.length; i++)
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

    public int getCount() {
        return imageUrls.length;
    }
}
