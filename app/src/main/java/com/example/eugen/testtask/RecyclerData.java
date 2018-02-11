package com.example.eugen.testtask;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by eugen on 12-Feb-18.
 */

public class RecyclerData {
    private HashMap<Integer, RecyclerItem> dataset;

    public RecyclerData(){
        dataset = new HashMap<>();
    }

    /**
     * Item will be added in any case, whether its parent exists or not
     * @param id
     * @param name
     * @param parentID
     */
    public void addItem(int id, String name, int parentID){
        addItem(id, name);
        if(dataset.containsKey(parentID)){
            RecyclerItem itemParent = dataset.get(parentID);
            itemParent.addChildren(id);
        }
    }

    public void addItem(int id, String name){
        RecyclerItem item = new RecyclerItem(id,name);
        dataset.put(id, item);
    }

    public RecyclerItem getItemById(int id){
        return dataset.get(id);
    }

    /**
     * Return item as a first element and its children
     * @param id
     * @return
     */
    public ArrayList<RecyclerItem> getItemsGroup(int id){
        RecyclerItem parentItem = dataset.get(id);
        ArrayList<RecyclerItem> items = new ArrayList<>();
        items.add(parentItem);
        for(Integer childId : parentItem.getChildrenIds()){
            items.add(dataset.get(childId));
        }
        return items;
    }
}
