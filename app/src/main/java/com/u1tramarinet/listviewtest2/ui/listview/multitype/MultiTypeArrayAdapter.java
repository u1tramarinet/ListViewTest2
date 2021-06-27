package com.u1tramarinet.listviewtest2.ui.listview.multitype;

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

public class MultiTypeArrayAdapter extends MyArrayAdapter<MyListItem> {
    private int[] resources = {
            R.layout.list_item_type_01,
            R.layout.list_item_type_02,
            R.layout.list_item_type_03,
            R.layout.list_item_type_04
    };

    public MultiTypeArrayAdapter(@NonNull Context context, @NonNull List<MyListItem> list) {
        super(context, R.layout.list_item_simple, list);
    }

    @Override
    public int getItemViewType(int position) {
        return position % resources.length;
    }

    @Override
    public int getViewTypeCount() {
        return resources.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final View view;
        int itemType = getItemViewType(position);
        if (convertView == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(resources[itemType], parent, false);
        } else {
            view = convertView;
        }
        TextView text = view.findViewById(R.id.text);
        MyListItem item = getItem(position);
        item.addGetViewInfo(position);
        text.setText(String.format(Locale.JAPAN, "position=%3d\nid=%3d", position, item.id));

        TextView info = view.findViewById(R.id.get_view_info_item);
        info.setText(item.getGetViewInfo());

        TextView infoView = view.findViewById(R.id.get_view_info_view);
        restoreAndSaveGetViewInfo(infoView, position);
        return view;
    }
}
