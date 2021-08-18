package com.u1tramarinet.listviewtest2.ui.listview.includebutton;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.u1tramarinet.listviewtest2.R;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

public class IncludeButtonListFragment extends Fragment {

    private Adapter adapter;
    private boolean enabled = true;

    public IncludeButtonListFragment() {
    }

    public static IncludeButtonListFragment newInstance() {
        return new IncludeButtonListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_include_button_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView listView = view.findViewById(R.id.list);
        adapter = new Adapter(requireContext());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view1, position, id) -> {
            Timber.d("onItemClickListener() position=%s", position);
            Toast.makeText(IncludeButtonListFragment.this.getContext(), "ListItem clicked!", Toast.LENGTH_SHORT).show();
        });
        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        enabled = !enabled;
                        Toast.makeText(IncludeButtonListFragment.this.getContext(), ((enabled) ? "Enabled" : "Disabled") + "!", Toast.LENGTH_SHORT).show();
                        adapter.setEnabled(enabled);
                        adapter.notifyDataSetChanged();
                    }
                };
                v.postDelayed(r, 2500);
                v.postDelayed(r, 5000);
            }
        });
    }

    private static class Adapter extends ArrayAdapter<ListItem> {
        private static final @LayoutRes
        int[] layoutIds = {
                R.layout.list_item_include_button_01,
                R.layout.list_item_include_button_02,
                R.layout.list_item_include_button_03,
                R.layout.list_item_include_button_04,
                R.layout.list_item_include_button_05,
                R.layout.list_item_include_button_06};
        private static final List<ListItem> defaultData = new ArrayList<>();
        private boolean enabled = true;

        static {
            defaultData.add(new ListItem());
            defaultData.add(new ListItem());
            defaultData.add(new ListItem());
            defaultData.add(new ListItem());
            defaultData.add(new ListItem());
            defaultData.add(new ListItem());
        }

        public Adapter(@NonNull Context context) {
            super(context, layoutIds[0], defaultData);
        }

        @Override
        public int getItemViewType(int position) {
            return position % getViewTypeCount();
        }

        @Override
        public int getViewTypeCount() {
            return layoutIds.length;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(parent.getContext()).inflate(layoutIds[getItemViewType(position)], parent, false);
            }
            Button button = convertView.findViewById(R.id.button);
            button.setEnabled(enabled);
            if (button != null && button.isClickable()) {
                button.setOnClickListener(v -> {
                    Timber.d("onClickListener() position=%s", position);
                    Toast.makeText(Adapter.this.getContext(), "Button clicked!", Toast.LENGTH_SHORT).show();
                });
            }
            return convertView;
        }

        private void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }
    }

    private static class ListItem {

    }
}