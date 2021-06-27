package com.u1tramarinet.listviewtest2.ui.listview.simple;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.u1tramarinet.listviewtest2.model.MyListItem;
import com.u1tramarinet.listviewtest2.ui.listview.BaseListViewFragment;
import com.u1tramarinet.listviewtest2.util.Logger;
import com.u1tramarinet.listviewtest2.widget.listview.MyArrayAdapter;

import java.util.StringJoiner;

public class SimpleListViewFragment extends BaseListViewFragment {
    private SimpleArrayAdapter adapter;

    public SimpleListViewFragment() {
    }

    public static SimpleListViewFragment newInstance() {
        return new SimpleListViewFragment();
    }

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new SimpleArrayAdapter(requireContext(), getListItem(20));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected MyArrayAdapter<MyListItem> getAdapter() {
        return adapter;
    }

    @Override
    protected void onClearChoicesButtonClicked() {
        super.onClearChoicesButtonClicked();
        long[] checkedIds = listView.getCheckedItemIds();
        StringJoiner joiner = new StringJoiner(",");
        for (long id : checkedIds) {
            joiner.add(String.valueOf(id));
        }
        Logger.d("CheckedIds=[" + joiner.toString() + "]");
    }
}