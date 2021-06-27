package com.u1tramarinet.listviewtest2.widget.listview;

import android.content.Context;
import android.database.DataSetObserver;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.u1tramarinet.listviewtest2.R;
import com.u1tramarinet.listviewtest2.util.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringJoiner;

public abstract class MyArrayAdapter<T> extends ArrayAdapter<T> {

    public MyArrayAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        initialize();
    }

    public MyArrayAdapter(@NonNull Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
        initialize();
    }

    public MyArrayAdapter(@NonNull Context context, int resource, @NonNull T[] objects) {
        super(context, resource, objects);
        initialize();
    }

    public MyArrayAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull T[] objects) {
        super(context, resource, textViewResourceId, objects);
        initialize();
    }

    public MyArrayAdapter(@NonNull Context context, int resource, @NonNull List<T> objects) {
        super(context, resource, objects);
        initialize();
    }

    public MyArrayAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<T> objects) {
        super(context, resource, textViewResourceId, objects);
        initialize();
    }

    @Override
    public void insert(@Nullable T object, int index) {
        super.insert(object, index);
    }

    protected void restoreAndSaveGetViewInfo(@NonNull TextView textView, int position) {
        Map<Integer, Integer> map = (Map<Integer, Integer>)textView.getTag(R.string.get_view_tag);
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(position, getValueFromMap(map, position) + 1);
        textView.setTag(R.string.get_view_tag, map);

        StringJoiner joiner = new StringJoiner(", ");
        String format = "%3d(p:%3d)";
        int totalCount = 0;
        for (Integer key : map.keySet()) {
            int value = getValueFromMap(map, key);
            joiner.add(String.format(Locale.JAPAN, format, value, key));
            totalCount += value;
        }
        String wholeFormat = "view=%3d\n[%s]";
        textView.setText(String.format(Locale.JAPAN, wholeFormat, totalCount, joiner.toString()));
    }

    @Override
    public boolean areAllItemsEnabled() {
        boolean result = super.areAllItemsEnabled();

        return result;
    }

    private int getValueFromMap(@NonNull Map<Integer, Integer> map, int key) {
        Integer currentValue = map.getOrDefault(key, 0);
        return (currentValue != null) ? currentValue : 0;
    }

    private void initialize() {
        setNotifyOnChange(true);
        registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                onDataSetChanged();
            }

            @Override
            public void onInvalidated() {
                super.onInvalidated();
                onDataSetInvalidated();
            }
        });
    }

    @CallSuper
    protected void onDataSetChanged() {
        Logger.d("onDataSetChanged()");
    }

    @CallSuper
    protected void onDataSetInvalidated() {
        Logger.d("onDatasetInvalidated");
    }
}
