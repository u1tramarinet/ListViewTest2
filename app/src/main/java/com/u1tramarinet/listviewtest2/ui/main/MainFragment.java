package com.u1tramarinet.listviewtest2.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.u1tramarinet.listviewtest2.R;
import com.u1tramarinet.listviewtest2.util.NavigationUtil;

public class MainFragment extends Fragment {

    public MainFragment() {
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button listViewButton = view.findViewById(R.id.list_view_button);
        listViewButton.setOnClickListener((v) -> NavigationUtil.navigate(v, MainFragmentDirections.actionMainFragmentToListViewNavGraph()));
        Button recyclerViewButton = view.findViewById(R.id.recycler_view_button);
        recyclerViewButton.setOnClickListener((v) -> NavigationUtil.navigate(v, MainFragmentDirections.actionMainFragmentToRecyclerViewNavGraph()));
    }
}