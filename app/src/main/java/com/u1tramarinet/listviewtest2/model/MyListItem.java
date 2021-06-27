package com.u1tramarinet.listviewtest2.model;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class MyListItem {
    public final long id;
    @NonNull
    private final Map<Integer, Integer> getViewInfo = new HashMap<>();

    public MyListItem(long id) {
        this.id = id;
    }

    public void addGetViewInfo(int position) {
        getViewInfo.put(position, getValueFromMap(position) + 1);
    }

    public String getGetViewInfo() {
        int totalCount = 0;
        for (Integer key : getViewInfo.keySet()) {
            int value = getValueFromMap(key);
            totalCount += value;
        }
        String wholeFormat = "getView's count\nitem=%3d";
        return String.format(Locale.JAPAN, wholeFormat, totalCount);
    }

    private int getValueFromMap(int key) {
        Integer currentValue = getViewInfo.getOrDefault(key, 0);
        return (currentValue != null) ? currentValue : 0;
    }
}
