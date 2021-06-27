package com.u1tramarinet.listviewtest2.ui.listview.expandable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.u1tramarinet.listviewtest2.R;
import com.u1tramarinet.listviewtest2.model.MyParentListItem;
import com.u1tramarinet.listviewtest2.widget.listview.MyExpandableListAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ExpandableAdapter extends MyExpandableListAdapter {

    public ExpandableAdapter(@NonNull @NotNull List<MyParentListItem> data) {
        super(data);
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        final View view;
        if (convertView == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_parent, parent, false);
        } else {
            view = convertView;
        }
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final View view;
        if (convertView == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_child, parent, false);
        } else {
            view = convertView;
        }
        return view;
    }
}
