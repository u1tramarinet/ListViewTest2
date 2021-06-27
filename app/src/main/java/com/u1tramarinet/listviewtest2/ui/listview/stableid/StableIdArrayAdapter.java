package com.u1tramarinet.listviewtest2.ui.listview.stableid;

import android.content.Context;

import androidx.annotation.NonNull;

import com.u1tramarinet.listviewtest2.model.MyListItem;
import com.u1tramarinet.listviewtest2.ui.listview.simple.SimpleArrayAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class StableIdArrayAdapter extends SimpleArrayAdapter {

    public StableIdArrayAdapter(@NonNull @NotNull Context context, @NonNull @NotNull List<MyListItem> list) {
        super(context, list);
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).id;
    }
}
