package com.example.eugen.testtask;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by eugen on 11-Feb-18.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private RecyclerData mDataset;
    private RecyclerView mRecyclerView;

    private abstract class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView) {
            super(itemView);
        }
        abstract public void setText(String text);
    }
    public class ViewHolderParent extends ViewHolder{
        public TextView mTextView;
        public ImageView mImageView;
        public ViewHolderParent(View v) {
            super(v);
            mTextView = v.findViewById(R.id.textViewP);
            mImageView = v.findViewById(R.id.arrow);
        }

        public void setFolded(){
            mImageView.setRotation(0);
        }

        public void setUnFolded(){
            mImageView.setRotation(180);
        }

        @Override
        public void setText(String text) {
            mTextView.setText(text);
        }
    }

    public class ViewHolderChild extends ViewHolder{
        public TextView mTextView;
        public ImageView mImageView;
        public ViewHolderChild(View v) {
            super(v);
            mTextView = v.findViewById(R.id.textViewC);
            mImageView = v.findViewById(R.id.child_checked);
        }

        public void setChecked(){
            show();
        }

        public void setUnChecked(){
            mTextView.setVisibility(View.VISIBLE);
            mImageView.setVisibility(View.INVISIBLE);
        }

        public void hide(){
            mTextView.setVisibility(View.GONE);
            mImageView.setVisibility(View.GONE);
        }

        public void show(){
            mTextView.setVisibility(View.VISIBLE);
            mImageView.setVisibility(View.VISIBLE);
        }

        @Override
        public void setText(String text) {
            mTextView.setText(text);
        }
    }

    public MyAdapter(RecyclerData dataset, RecyclerView rv) {
        mDataset = dataset;
        mRecyclerView = rv;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ViewHolder vh = null;
        View view = null;

        if(viewType == RecyclerItem.ITEM_CHILD_CHECKED){
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.child_view_holder_layout, parent, false);
            ViewHolderChild vhBuf = new ViewHolderChild(view);
            vhBuf.setChecked();
            vh = vhBuf;
        }
        else if(viewType == RecyclerItem.ITEM_CHILD_UNCHECKED){
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.child_view_holder_layout, parent, false);
            ViewHolderChild vhBuf = new ViewHolderChild(view);
            vhBuf.setUnChecked();
            vh = vhBuf;
        }
        else if(viewType == RecyclerItem.ITEM_CHILD_FOLDED){
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.child_view_holder_layout, parent, false);
            ViewHolderChild vhBuf = new ViewHolderChild(view);
            vhBuf.hide();
            vh = vhBuf;
        }
        else if(viewType == RecyclerItem.ITEM_PARENT_FOLDED){
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.view_holder_layout, parent, false);
            ViewHolderParent vhBuf = new ViewHolderParent(view);
            vhBuf.setFolded();
            vh = vhBuf;
        }
        else if(viewType == RecyclerItem.ITEM_PARENT_UNFOLDED){
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.view_holder_layout, parent, false);
            ViewHolderParent vhBuf = new ViewHolderParent(view);
            vhBuf.setUnFolded();
            vh = vhBuf;
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int itemPosition = mRecyclerView.getChildLayoutPosition(view);
                mDataset.toggleItem(itemPosition);
                notifyDataSetChanged();
            }
        });

        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
   
        ((ViewHolder)holder).setText(mDataset.get(position).getName());
        int viewType = holder.getItemViewType();

        if(viewType == RecyclerItem.ITEM_CHILD_CHECKED){
            ViewHolderChild vhBuf = (ViewHolderChild) holder;
            vhBuf.setChecked();
        }
        else if(viewType == RecyclerItem.ITEM_CHILD_UNCHECKED){
            ViewHolderChild vhBuf = (ViewHolderChild) holder;
            vhBuf.setUnChecked();
        }
        else if(viewType == RecyclerItem.ITEM_CHILD_FOLDED){
            ViewHolderChild vhBuf = (ViewHolderChild) holder;
            vhBuf.hide();
        }
        else if(viewType == RecyclerItem.ITEM_PARENT_FOLDED){
            ViewHolderParent vhBuf = (ViewHolderParent) holder;
            vhBuf.setFolded();
        }
        else if(viewType == RecyclerItem.ITEM_PARENT_UNFOLDED){
            ViewHolderParent vhBuf = (ViewHolderParent) holder;
            vhBuf.setUnFolded();
        }
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
