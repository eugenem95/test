package com.example.eugen.testtask;

import java.util.ArrayList;

/**
 * Created by eugen on 12-Feb-18.
 */

public class RecyclerItem {
    private String name;
    private int id;
    private int parentId = -1; // -1 if parent
    private boolean checked = false;// for child items only
    private boolean folded = true;

    public static final int ITEM_PARENT_FOLDED = 0;
    public static final int ITEM_PARENT_UNFOLDED  = 1;
    public static final int ITEM_CHILD_FOLDED  = 2;
    public static final int ITEM_CHILD_CHECKED  = 3;
    public static final int ITEM_CHILD_UNCHECKED  = 4;

    public RecyclerItem(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public RecyclerItem(int id, String name, int parentId) {
        this.name = name;
        this.id = id;
        this.parentId = parentId;
    }

    public void setChecked(boolean checked){
        this.checked = checked;
    }

    public void setFolded(boolean folded){
        this.folded = folded;
    }

    public int getParentId() {
        return parentId;
    }

    public int getType(){
        if(parentId == -1 && folded == false)
            return ITEM_PARENT_UNFOLDED;
        else if(parentId == -1 && folded == true)
            return ITEM_PARENT_FOLDED;
        else if(parentId != -1 && folded == true)
            return ITEM_CHILD_FOLDED;
        else if(parentId != -1 && checked == true)
            return ITEM_CHILD_CHECKED;
        else if(parentId != -1 && checked == false)
            return ITEM_CHILD_UNCHECKED;

        return -1;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
