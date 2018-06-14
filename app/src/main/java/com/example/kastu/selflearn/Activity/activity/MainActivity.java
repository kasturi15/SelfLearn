package com.example.kastu.selflearn.Activity.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.kastu.selflearn.Activity.adapter.MyAdapter;
import com.example.kastu.selflearn.Activity.model.ListItem;
import com.example.kastu.selflearn.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String url = "https://raw.githubusercontent.com/kasturi15/Hello_world/master/data.json";

    private RecyclerView mList;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mList = findViewById(R.id.recyclerview);

        listItems = new ArrayList<>();
        adapter = new MyAdapter(listItems,getApplicationContext());

        mList.setHasFixedSize(true);
        mList.setLayoutManager(new LinearLayoutManager(this));

        mList.setAdapter(adapter);

        getData();

    }

    private void getData() {

        final ProgressDialog  progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i = 0; i < response.length(); i++) {

                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        ListItem list = new ListItem();

                        list.setHead(jsonObject.getString("head"));
                        list.setDesc(jsonObject.getString("desc"));
                        list.setImageUrl(jsonObject.getString("imageurl"));
                        list.setLike(jsonObject.getInt("like"));
                        list.setHate(jsonObject.getInt("hate"));
                        list.setLove(jsonObject.getInt("love"));

                        listItems.add(list);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        progressDialog.dismiss();
                    }
                }
                adapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
                progressDialog.dismiss();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }
}
