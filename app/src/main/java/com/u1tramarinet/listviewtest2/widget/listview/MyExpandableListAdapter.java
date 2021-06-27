package com.u1tramarinet.listviewtest2.widget.listview;

import android.widget.BaseExpandableListAdapter;

import androidx.annotation.NonNull;

import com.u1tramarinet.listviewtest2.model.MyListItem;
import com.u1tramarinet.listviewtest2.model.MyParentListItem;

import java.util.List;

public abstract class MyExpandableListAdapter extends BaseExpandableListAdapter {

    private final List<MyParentListItem> data;

    public MyExpandableListAdapter(@NonNull List<MyParentListItem> data) {
        this.data = data;
    }

    @Override
    public int getGroupCount() {
        return data.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return data.get(groupPosition).children.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return data.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return data.get(groupPosition).children.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    public void insert(@NonNull MyParentListItem parent, int index) {
        data.add(index, parent);
        notifyDataSetChanged();
    }

    public void insert(@NonNull MyListItem child, int index) {
        data.get(index).children.add(child);
        notifyDataSetChanged();
    }
}
