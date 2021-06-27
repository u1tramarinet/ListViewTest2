package com.u1tramarinet.listviewtest2.ui.listview.expandable;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.u1tramarinet.listviewtest2.R;
import com.u1tramarinet.listviewtest2.model.MyListItem;
import com.u1tramarinet.listviewtest2.model.MyParentListItem;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExpandableListViewFragment extends Fragment {

    private ExpandableListView expandableListView;
    private ExpandableAdapter adapter;

    public ExpandableListViewFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_expandable_list_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        expandableListView = view.findViewById(R.id.expandable_list_view);
        adapter = new ExpandableAdapter(getListItem(10));
        expandableListView.setAdapter(adapter);
    }

    private List<MyParentListItem> getListItem(int size) {
        List<Integer> ids = getRandomIntegers(size);
        List<MyParentListItem> parents = new ArrayList<>();
        for (Integer integer : ids) {
            parents.add(getParent(integer, 5));
        }
        return parents;
    }

    private MyParentListItem getParent(long id, int childrenSize) {
        List<Integer> ids = getRandomIntegers(childrenSize);
        List<MyListItem> children = new ArrayList<>();
        for (Integer integer : ids) {
            children.add(new MyListItem(integer));
        }
        return new MyParentListItem(id, children);
    }

    private List<Integer> getRandomIntegers(int size) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            integers.add(i);
        }
        Collections.shuffle(integers);
        return integers;
    }
}