package com.example.eugen.testtask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        RecyclerData data = new RecyclerData();
        data.addItem(0,"testItem0");
        data.addItem(1,"testItem01", 0);
        data.addItem(2,"testItem02", 0);
        data.addItem(3,"testItem03", 0);

        data.addItem(4,"testItem1");
        data.addItem(4,"testItem11", 4);
        data.addItem(5,"testItem12", 4);
        data.addItem(6,"testItem13", 4);


        mAdapter = new MyAdapter(data, mRecyclerView);

        mRecyclerView.setAdapter(mAdapter);
    }
}
