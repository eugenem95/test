package com.example.eugen.testtask;

import java.util.ArrayList;

/**
 * Created by eugen on 12-Feb-18.
 */

public class RecyclerItem {

    public RecyclerItem(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public void addChildren(int childId){
        if(childrenIds == null){
            childrenIds = new ArrayList<>();
        }
        childrenIds.add(childId);
    }

    public ArrayList<Integer> getChildrenIds(){
        return childrenIds;
    }

    public String name;
    public int id;
    private ArrayList<Integer> childrenIds;

}
