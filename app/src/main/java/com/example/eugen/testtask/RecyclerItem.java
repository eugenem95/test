package com.example.eugen.testtask;

import java.util.ArrayList;

/**
 * Created by eugen on 12-Feb-18.
 */

public class RecyclerItem {
    public String name;
    public int id;
    public int parentId = -1; // -1 if parent

    public static final int ITEM_PARENT = 0;
    public static final int ITEM_CHILD  = 1;

    public RecyclerItem(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public RecyclerItem(int id, String name, int parentId) {
        this.name = name;
        this.id = id;
        this.parentId = parentId;
    }

    public int getType(){
        if(parentId == -1)
            return ITEM_PARENT;
        else
            return  ITEM_CHILD;
    }
}
