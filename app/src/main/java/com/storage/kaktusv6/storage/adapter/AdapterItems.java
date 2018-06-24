package com.storage.kaktusv6.storage.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.storage.kaktusv6.storage.R;
import com.storage.kaktusv6.storage.filters.ItemFilter;
import com.storage.kaktusv6.storage.structure.Item;

import java.util.ArrayList;

public class AdapterItems extends BaseAdapter implements Filterable {
    private LayoutInflater lInflater;
    private ArrayList<Item> originalItems;
    private ArrayList<Item> filteredItems;
    private ItemFilter mFilter;

    public ArrayList<Item> getOriginalItems() {
        return originalItems;
    }

    public void setFilteredItems(ArrayList<Item> filteredItems) {
        this.filteredItems = filteredItems;
    }

    public AdapterItems(Context context, ArrayList<Item> values) {
        originalItems = values;
        filteredItems = values;
        lInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        mFilter = new ItemFilter(this);
    }

    // кол-во элементов
    @Override
    public int getCount() {
        return filteredItems.size();
    }

    // элемент по позиции
    @Override
    public Object getItem(int position) {
        return filteredItems.get(position);
    }

    // id по позиции
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
            view = lInflater.inflate(R.layout.item_list_view, parent, false);
        }

        Item p = (Item) getItem(position);

        // заполняем View в пункте списка данными из товаров: наименование, цена
        // и картинка
        ((TextView) view.findViewById(R.id.titleItem)).setText(p.getName());
//        ((TextView) view.findViewById(R.id.descItem)).setText(p.getCode());

        return view;
    }

    // Получение фильтра
    @Override
    public Filter getFilter() {
        return mFilter;
    }
}
