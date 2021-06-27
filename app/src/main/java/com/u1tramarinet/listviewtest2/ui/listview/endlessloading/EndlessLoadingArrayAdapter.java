package com.u1tramarinet.listviewtest2.ui.listview.endlessloading;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.u1tramarinet.listviewtest2.R;
import com.u1tramarinet.listviewtest2.model.MyListItem;
import com.u1tramarinet.listviewtest2.ui.listview.simple.SimpleArrayAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Locale;

public class EndlessLoadingArrayAdapter extends SimpleArrayAdapter {
    private static final int resource = R.layout.list_item_simple;
    private static final int resource_loading = R.layout.list_item_loading;

    public EndlessLoadingArrayAdapter(@NonNull @NotNull Context context, @NonNull @NotNull List<MyListItem> list) {
        super(context, list);
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        int lastPosition = getCount() - 1;
        return (position == lastPosition) ? 1 : 0;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final View view;
        final int res = (getItemViewType(position) == 0) ? resource : resource_loading;

        if (convertView == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(res, parent, false);
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
