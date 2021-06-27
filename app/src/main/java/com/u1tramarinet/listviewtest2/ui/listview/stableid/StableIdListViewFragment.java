package com.u1tramarinet.listviewtest2.ui.listview.stableid;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.u1tramarinet.listviewtest2.model.MyListItem;
import com.u1tramarinet.listviewtest2.ui.listview.BaseListViewFragment;
import com.u1tramarinet.listviewtest2.util.Logger;
import com.u1tramarinet.listviewtest2.widget.listview.MyArrayAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.StringJoiner;

public class StableIdListViewFragment extends BaseListViewFragment {

    private StableIdArrayAdapter adapter;

    public StableIdListViewFragment() {
    }

    public static StableIdListViewFragment newInstance() {
        return new StableIdListViewFragment();
    }

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new StableIdArrayAdapter(requireContext(), getListItem(20));
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected MyArrayAdapter<MyListItem> getAdapter() {
        return adapter;
    }

    @Override
    protected void onSrlRefreshed() {
        super.onSrlRefreshed();
        adapter.notifyDataSetChanged();
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