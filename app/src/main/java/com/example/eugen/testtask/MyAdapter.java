package com.example.eugen.testtask;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by eugen on 11-Feb-18.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private RecyclerData mDataset;
    private RecyclerView mRecyclerView;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public ViewHolder(View v) {
            super(v);
            mTextView = v.findViewById(R.id.textView);
        }

    }

    public MyAdapter(RecyclerData dataset, RecyclerView recyclerView) {
        mRecyclerView = recyclerView;
        mDataset = dataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ViewHolder vh = null;
        switch (viewType){
            case RecyclerItem.ITEM_CHILD:
                View vChild = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.child_view_holder_layout, parent, false);
                vh = new ViewHolder(vChild);
                break;

            case RecyclerItem.ITEM_PARENT:
                View vParent = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.view_holder_layout, parent, false);
                vh = new ViewHolder(vParent);
                break;
        }



//        v.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int itemPosition = mRecyclerView.getChildLayoutPosition(view);
//                String item = mDataset[itemPosition];
//                Toast.makeText(mRecyclerView.getContext(), item, Toast.LENGTH_SHORT).show();
//            }
//        });


        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText("test");
    }

    @Override
    public int getItemCount() {
        return mDataset.getSize();
    }

    @Override
    public int getItemViewType(int position) {
        return mDataset.get(position).getType();
    }
}
