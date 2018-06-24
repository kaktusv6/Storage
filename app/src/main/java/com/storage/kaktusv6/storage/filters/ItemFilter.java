package com.storage.kaktusv6.storage.filters;

import android.util.Log;
import android.widget.Filter;

import com.storage.kaktusv6.storage.adapter.AdapterItems;
import com.storage.kaktusv6.storage.structure.Item;

import java.util.ArrayList;

public class ItemFilter extends Filter {
    private ArrayList<Item> originalList; // ссылка на оригинальные данные
    private AdapterItems adapter; // Ссылка на Adapter

    public ItemFilter(AdapterItems adapter) {
        // Получаем ссылки на массивы и Adapter
        this.adapter = adapter;
        this.originalList = adapter.getOriginalItems();
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
//        Log.d("Filter", constraint.toString());
        // Приводим строку фильтрации к нижнему регистру
        String filterString = constraint.toString().toLowerCase();

        // Создаем объект хранящий результат фильтрации
        FilterResults results = new FilterResults();

        // Получаем размер массива
        int count = originalList.size();
        // Формируем новый отфильтрованный массив
        ArrayList<Item> newList = new ArrayList<Item>();

        // Строка сравнения
        String filterableString;

        for (int i = 0; i < count; i++) {
            // Фильтруем товар по имени
            filterableString = originalList.get(i).getName();
            // Если строка фильтрации содержится в название item
            if (filterableString.toLowerCase().contains(filterString)) {
                // То добавляем item в список отфильтрованных
                newList.add(originalList.get(i));
            }
        }

        // Формируем результат фильтрации
        results.values = newList;
        results.count = newList.size();

        // Отправляем результат
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        // Публикуем отфильтрованный массив
        adapter.setFilteredItems((ArrayList<Item>) results.values);
        // Сообщаем об изменениях в данных адаптера
        adapter.notifyDataSetChanged();
    }
}
