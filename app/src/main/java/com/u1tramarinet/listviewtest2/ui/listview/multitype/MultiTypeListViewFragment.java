package com.u1tramarinet.listviewtest2.ui.listview.multitype;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.u1tramarinet.listviewtest2.model.MyListItem;
import com.u1tramarinet.listviewtest2.ui.listview.BaseListViewFragment;
import com.u1tramarinet.listviewtest2.widget.listview.MyArrayAdapter;

import org.jetbrains.annotations.NotNull;

public class MultiTypeListViewFragment extends BaseListViewFragment {

    private MultiTypeArrayAdapter adapter;

    public MultiTypeListViewFragment() {
    }

    public static MultiTypeListViewFragment newInstance() {
        return new MultiTypeListViewFragment();
    }

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new MultiTypeArrayAdapter(requireContext(), getListItem(16));
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected MyArrayAdapter<MyListItem> getAdapter() {
        return adapter;
    }
}