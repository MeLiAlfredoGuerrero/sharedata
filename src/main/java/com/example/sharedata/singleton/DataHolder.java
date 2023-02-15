package com.example.sharedata.singleton;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class DataHolder {
    Map<String, WeakReference<String>> data = new HashMap<String, WeakReference<String>>();

    public void put(String id, String text) {
        WeakReference<String> string = new WeakReference<String>(text);
        data.put(id, string);
    }

    public String get(String id) {
        WeakReference<String> objectWeakReference = data.get(id);
        return objectWeakReference != null ? objectWeakReference.get() : null;
    }

    private static final DataHolder holder = new DataHolder();
    public static DataHolder getInstance() {return holder;}
}
