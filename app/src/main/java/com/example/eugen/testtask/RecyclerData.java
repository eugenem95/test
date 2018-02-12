package com.example.eugen.testtask;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by eugen on 12-Feb-18.
 */

public class RecyclerData {
    private ArrayList<RecyclerItem> dataset;

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
}
