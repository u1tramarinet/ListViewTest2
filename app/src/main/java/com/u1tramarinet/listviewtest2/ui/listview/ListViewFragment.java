package com.u1tramarinet.listviewtest2.ui.listview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;

import com.u1tramarinet.listviewtest2.R;
import com.u1tramarinet.listviewtest2.util.NavigationUtil;

public class ListViewFragment extends Fragment {

    public ListViewFragment() {
    }

    public static ListViewFragment newInstance() {
        return new ListViewFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupAction(view, R.id.simple_list_button, ListViewFragmentDirections.actionListViewFragmentToSimpleListViewFragment());
        setupAction(view, R.id.multi_type_list_button, ListViewFragmentDirections.actionListViewFragmentToMultiTypeListViewFragment());
        setupAction(view, R.id.stable_id_list_button, ListViewFragmentDirections.actionListViewFragmentToStableIdListViewFragment());
        setupAction(view, R.id.endless_loading_list_button, ListViewFragmentDirections.actionListViewFragmentToEndlessLoadingListViewFragment());
        setupAction(view, R.id.expandable_list_button, ListViewFragmentDirections.actionListViewFragmentToExpandableListViewFragment());
        setupAction(view, R.id.include_button_list_button, ListViewFragmentDirections.actionListViewFragmentToIncludeButtonListFragment());
    }

    private void setupAction(@NonNull View root, @IdRes int resId, @NonNull NavDirections action) {
        Button button = root.findViewById(resId);
        if (button != null) {
            button.setOnClickListener((v) -> NavigationUtil.navigate(root, action));
        }
    }
}