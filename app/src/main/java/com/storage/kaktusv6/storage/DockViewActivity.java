package com.storage.kaktusv6.storage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.storage.kaktusv6.storage.adapter.AdapterDock;
import com.storage.kaktusv6.storage.structure.Item;
import com.storage.kaktusv6.storage.structure.ItemDock;
import com.storage.kaktusv6.storage.structure.TypeLoad;

import java.util.ArrayList;

public class DockViewActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<ItemDock> list = new ArrayList<ItemDock>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dock_view);

        listView = (ListView) findViewById(R.id.list_item_dock);

        list.add(new ItemDock(new Item("Товар 1", 123), 120.500, TypeLoad.LOAD, "P01-152-3"));
        list.add(new ItemDock(new Item("Товар 2", 123), 120.500, TypeLoad.LOAD, "P01-152-3"));
        list.add(new ItemDock(new Item("Товар 3", 123), 120.500, TypeLoad.LOAD, "P01-152-3"));
        list.add(new ItemDock(new Item("Товар 1", 432), 120.500, TypeLoad.LOAD, "P01-152-3"));
        list.add(new ItemDock(new Item("Товар 1", 456), 120.500, TypeLoad.LOAD, "P01-152-3"));
        list.add(new ItemDock(new Item("Товар 1", 6758), 120.500, TypeLoad.UPLOAD, "P01-152-3"));
        list.add(new ItemDock(new Item("Товар 1", 124), 120.500, TypeLoad.LOAD, "P01-152-3"));
        list.add(new ItemDock(new Item("Товар 1", 764), 120.500, TypeLoad.LOAD, "P01-152-3"));

        AdapterDock adapter = new AdapterDock(this, list);
        listView.setAdapter(adapter);
    }
}
