package com.u1tramarinet.listviewtest2.model;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyParentListItem extends MyListItem {

    public final List<MyListItem> children;

    public MyParentListItem(long id) {
        this(id, null);
    }

    public MyParentListItem(long id, @Nullable List<MyListItem> children) {
        super(id);
        if (children == null) {
            children = new ArrayList<>();
        }
        this.children = children;
    }
}
