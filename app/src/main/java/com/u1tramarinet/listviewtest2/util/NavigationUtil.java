package com.u1tramarinet.listviewtest2.util;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

public class NavigationUtil {
    private NavigationUtil() {

    }

    public static void navigate(@NonNull View view, NavDirections action) {
        Navigation.findNavController(view).navigate(action);
    }
}
