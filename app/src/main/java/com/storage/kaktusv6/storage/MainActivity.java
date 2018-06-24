package com.storage.kaktusv6.storage;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.storage.kaktusv6.storage.adapter.AdapterItems;
import com.storage.kaktusv6.storage.settings.Settings;
import com.storage.kaktusv6.storage.structure.Item;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static String BASE_URL = "http://192.168.0.100/";
    static String PATH_URL = "Storage/hs/our-service/";

    SharedPreferences mSettings;

    SearchView searchView;
    ListView listView;
    ArrayList<Item> items = new ArrayList<>();

    AdapterItems adapter;

    Dialog popup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        popup = new Dialog(this);
        mSettings = getSharedPreferences(Settings.APP_PREFERENCES, Context.MODE_PRIVATE);

        if (mSettings.contains(Settings.APP_PREFERENCES_BASE_URL)) {
            // Получаем baseUrl из настроек
            BASE_URL = mSettings.getString(Settings.APP_PREFERENCES_BASE_URL, Settings.getBase_url());
        }

        if (mSettings.contains(Settings.APP_PREFERENCES_PATH_URL)) {
            // Получаем pathUrl из настроек
            PATH_URL = mSettings.getString(Settings.APP_PREFERENCES_PATH_URL, Settings.getPath_url());
        }

        searchView = (SearchView) findViewById(R.id.search);
        listView = (ListView) findViewById(R.id.listView);

        items.add(new Item("Cat", 123));
        items.add(new Item("Cats", 1234));
        items.add(new Item("City", 1235));
        items.add(new Item("Word", 1236));
        items.add(new Item("Home", 1237));
        items.add(new Item("Computer", 1238));
        items.add(new Item("Music", 1239));
        items.add(new Item("Rock", 1230));

        adapter = new AdapterItems(this, items);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item getItem = (Item) adapter.getItem(position);

                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.item_popup, null);

                TextView textView = (TextView) mView.findViewById(R.id.name_item);
                TextView close = (TextView) mView.findViewById(R.id.close_popup);

                textView.setText(getItem.getName());

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Настройки подключения");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent settings = new Intent(this, SettingsActivity.class);
        startActivity(settings);

        return super.onOptionsItemSelected(item);
    }
}
