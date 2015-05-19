package com.asia.recycleviewdemo;

import com.asia.recycleviewdemo.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private void initView(){
        recyclerView = (RecyclerView) super.findViewById(R.id.recylerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        String[] data = new String[50];
        for (int i = 0; i < 50; i++) {
            data[i] = i + "";
        }
        CustomAdapter adapter = new CustomAdapter(data);
        recyclerView.setAdapter(adapter);
    }
}
