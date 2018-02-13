package com.example.eugen.testtask;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by eugen on 12-Feb-18.
 */

public class RecyclerData {
    private ArrayList<RecyclerItem> dataset;

    //child item was not selected yet
    //checked == unfolded for parentItems
    private int childItemSelectedID = -1;

    public RecyclerData(){
        dataset = new ArrayList<>();
    }

    public void addItem(int id, String name, int parentID){
        dataset.add(new RecyclerItem(id, name, parentID));
    }

    public void addItem(int id, String name){
        dataset.add(new RecyclerItem(id, name));
    }

    public RecyclerItem get(int index){
        return dataset.get(index);
    }

    public int getSize(){
        return dataset.size();
    }

    public RecyclerItem getItemByID(int id){
        for(RecyclerItem curItem : dataset) {
            if (curItem.getId() == id)
                return curItem;
        }
        return null;
    }

    public void toggleItem(int itemNumber){
        RecyclerItem item = dataset.get(itemNumber);
        //Log.i("qweqweqwe", String.valueOf(item.getType()));
        if(item.getType() == RecyclerItem.ITEM_CHILD_UNCHECKED){
            //need to unCheck previously selected child item
            if(childItemSelectedID != -1) {
                getItemByID(childItemSelectedID).setChecked(false);
            }
            item.setChecked(true);
            childItemSelectedID = item.getId();
        }
        else if(item.getType() == RecyclerItem.ITEM_PARENT_FOLDED){
            item.setFolded(false);
            for(int i = 0; i < dataset.size(); i++){
                if(dataset.get(i).getParentId() == item.getId()){
                    dataset.get(i).setFolded(false);
                }
            }
        }
        else if(item.getType() == RecyclerItem.ITEM_PARENT_UNFOLDED){
            item.setFolded(true);
            for(int i = 0; i < dataset.size(); i++){
                if(dataset.get(i).getParentId() == item.getId()){
                    dataset.get(i).setFolded(true);
                }
            }
        }
        //if child item was already checked - do nothing
    }

}
