package com.storage.kaktusv6.storage.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.TextView;

import com.storage.kaktusv6.storage.R;

import com.storage.kaktusv6.storage.structure.ItemDock;
import com.storage.kaktusv6.storage.structure.TypeLoad;

import java.util.ArrayList;

public class AdapterDock extends BaseAdapter {
    private LayoutInflater lInflater;
    private ArrayList<ItemDock> items;

    public AdapterDock(Context context, ArrayList<ItemDock> values) {
        items = values;
        lInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // кол-во элементов
    @Override
    public int getCount() {
        return items.size();
    }

    // элемент по позиции
    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // пункт списка
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // используем созданные, но не используемые view
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.item_dock, parent, false);
        }

        ItemDock p = (ItemDock) getItem(position);

        // заполняем View в пункте списка данными из товаров: наименование, цена
        ((TextView) view.findViewById(R.id.name_item)).setText(p.getItem().getName());
        TypeLoad typeLoad = p.getTypeLoad();
        String strTypeLoad = "Загружено";
        if (typeLoad == TypeLoad.UPLOAD) {
            strTypeLoad = "Отгружено";
        }

        ((TextView) view.findViewById(R.id.type_load)).setText(strTypeLoad);
        ((TextView) view.findViewById(R.id.name_box)).setText(p.getNameBox());
        ((TextView) view.findViewById(R.id.length_item)).setText(Double.toString(p.getLength()));

        return view;
    }
}
