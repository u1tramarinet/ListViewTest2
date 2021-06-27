package com.u1tramarinet.listviewtest2.ui.listview.simple;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.u1tramarinet.listviewtest2.R;
import com.u1tramarinet.listviewtest2.model.MyListItem;
import com.u1tramarinet.listviewtest2.widget.listview.MyArrayAdapter;

import java.util.List;
import java.util.Locale;

public class SimpleArrayAdapter extends MyArrayAdapter<MyListItem> {
    private static final int resource = R.layout.list_item_simple;

    public SimpleArrayAdapter(@NonNull Context context, @NonNull List<MyListItem> list) {
        super(context, resource, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final View view;
        if (convertView == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        } else {
            view = convertView;
        }
        TextView text = view.findViewById(R.id.text_one);
        MyListItem item = getItem(position);
        long itemId = getItemId(position);
        item.addGetViewInfo(position);
        text.setText(String.format(Locale.JAPAN, "position=%3d\nitemId=%3d", position, itemId));

        TextView info = view.findViewById(R.id.get_view_info_item);
        info.setText(item.getGetViewInfo());
        TextView infoView = view.findViewById(R.id.get_view_info_view);
        restoreAndSaveGetViewInfo(infoView, position);
        return view;
    }
}
