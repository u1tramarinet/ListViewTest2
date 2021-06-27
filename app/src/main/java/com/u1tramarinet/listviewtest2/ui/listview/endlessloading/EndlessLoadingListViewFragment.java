package com.u1tramarinet.listviewtest2.ui.listview.endlessloading;

import android.os.Bundle;

import com.u1tramarinet.listviewtest2.model.MyListItem;
import com.u1tramarinet.listviewtest2.ui.listview.BaseListViewFragment;
import com.u1tramarinet.listviewtest2.widget.listview.MyArrayAdapter;

public class EndlessLoadingListViewFragment extends BaseListViewFragment {

    private EndlessLoadingArrayAdapter adapter;

    public EndlessLoadingListViewFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new EndlessLoadingArrayAdapter(requireContext(), getListItem(2));
    }

    @Override
    protected MyArrayAdapter<MyListItem> getAdapter() {
        return adapter;
    }
}