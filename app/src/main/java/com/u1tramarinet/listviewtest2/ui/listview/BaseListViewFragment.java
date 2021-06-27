package com.u1tramarinet.listviewtest2.ui.listview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.u1tramarinet.listviewtest2.R;
import com.u1tramarinet.listviewtest2.model.MyListItem;
import com.u1tramarinet.listviewtest2.widget.listview.MyArrayAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class BaseListViewFragment extends Fragment {

    protected ListView listView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ChoiceMode choiceMode = ChoiceMode.NONE;
    private MyArrayAdapter<MyListItem> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_base_list_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = getAdapter();
        listView = view.findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setChoiceMode(choiceMode.value);
        listView.setOnItemClickListener((parent, view1, position, id) -> BaseListViewFragment.this.onItemClick(position, id));
        listView.setOnItemLongClickListener((parent, view12, position, id) -> BaseListViewFragment.this.onItemLongClick(position, id));
        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                BaseListViewFragment.this.onItemSelected(position, id);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                BaseListViewFragment.this.onNothingSelected();
            }
        });
        switchChoiceMode(null);
        ExtendedFloatingActionButton clearChoicesButton = view.findViewById(R.id.clear_choices_button);
        clearChoicesButton.setOnClickListener((v) -> onClearChoicesButtonClicked());
        swipeRefreshLayout = view.findViewById(R.id.srl);
        swipeRefreshLayout.setOnRefreshListener(this::onSrlRefreshed);
        ExtendedFloatingActionButton insertButton = view.findViewById(R.id.insert_button);
        insertButton.setOnClickListener((v) -> onInsertButtonClicked());
        ExtendedFloatingActionButton insertDupButton = view.findViewById(R.id.insert_duplicate_button);
        insertDupButton.setOnClickListener((v) -> onInsertDuplicateButtonClicked());
    }

    protected abstract MyArrayAdapter<MyListItem> getAdapter();

    protected List<MyListItem> getListItem(int size) {
        if (size <= 0) return new ArrayList<>();

        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            indexes.add(i + 1);
        }
        Collections.shuffle(indexes);

        List<MyListItem> items = new ArrayList<>();
        for (Integer id : indexes) {
            items.add(new MyListItem(id));
        }
        return items;
    }

    protected void onClearChoicesButtonClicked() {
        listView.clearChoices();
        adapter.notifyDataSetChanged();
    }

    protected void onInsertButtonClicked() {
        insertItemAndUpdate(0, false);
    }

    protected void onInsertDuplicateButtonClicked() {
        insertItemAndUpdate(0, true);
    }

    protected void onSrlRefreshed() {
        switchChoiceMode(ChoiceMode.next(choiceMode));
        stopRefreshing();
    }

    protected void stopRefreshing() {
        if (null != swipeRefreshLayout) {
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    protected void onItemClick(int position, long id) {
        Toast.makeText(requireContext(), "onItemClick() position=" + position + ", id=" + id, Toast.LENGTH_SHORT).show();
    }

    protected boolean onItemLongClick(int position, long id) {
        Toast.makeText(requireContext(), "onItemLongClick() position=" + position + ", id=" + id, Toast.LENGTH_SHORT).show();
        return false;
    }

    protected void onItemSelected(int position, long id) {
        Toast.makeText(requireContext(), "onItemSelected() position=" + position + ", id=" + id, Toast.LENGTH_SHORT).show();
    }

    protected void onNothingSelected() {
        Toast.makeText(requireContext(), "onNothingSelected()", Toast.LENGTH_SHORT).show();
    }

    protected void insertItemAndUpdate(int index, boolean duplicate) {
        MyListItem item;
        if (duplicate) {
            item = getListItem(1).get(0);
        } else {
            int size = adapter.getCount();
            item = new MyListItem(size);
        }

        adapter.insert(item, index);
        adapter.notifyDataSetChanged();
    }

    private void switchChoiceMode(ChoiceMode mode) {
        mode = (null != mode) ? mode : ChoiceMode.NONE;
        choiceMode = mode;
        listView.clearChoices();
        listView.setChoiceMode(choiceMode.value);
        Toast.makeText(requireContext(), "ChoiceMode is " + choiceMode.name(), Toast.LENGTH_SHORT).show();
    }

    private enum ChoiceMode {
        NONE(AbsListView.CHOICE_MODE_NONE),
        SINGLE(AbsListView.CHOICE_MODE_SINGLE),
        MULTI(AbsListView.CHOICE_MODE_MULTIPLE);

        private final int value;

        ChoiceMode(int value) {
            this.value = value;
        }

        private static ChoiceMode next(ChoiceMode current) {
            ChoiceMode[] values = ChoiceMode.values();
            int length = values.length;
            int nextIndex = (current.ordinal() + 1) % length;
            return values[nextIndex];
        }
    }
}