package com.storage.kaktusv6.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.storage.kaktusv6.storage.settings.Settings;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    SharedPreferences mSettings;

    EditText editTextBaseUrl;
    EditText editTextPathUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        mSettings = getSharedPreferences(Settings.APP_PREFERENCES, Context.MODE_PRIVATE);

        editTextBaseUrl = (EditText) findViewById(R.id.editTextBaseUrl);
        editTextPathUrl = (EditText) findViewById(R.id.editTextPathUrl);

        if (mSettings.contains(Settings.APP_PREFERENCES_BASE_URL)) {
            // Получаем baseUrl из настроек
            editTextBaseUrl.setText(mSettings.getString(Settings.APP_PREFERENCES_BASE_URL, Settings.getBase_url()));
        }
        else {
            editTextBaseUrl.setText(Settings.getBase_url());
        }

        if (mSettings.contains(Settings.APP_PREFERENCES_PATH_URL)) {
            // Получаем pathUrl из настроек
            editTextPathUrl.setText(mSettings.getString(Settings.APP_PREFERENCES_PATH_URL, Settings.getPath_url()));
        }
        else {
            editTextPathUrl.setText(Settings.getPath_url());
        }

        Button btnSave = (Button)findViewById(R.id.buttonSaveSettings);
        btnSave.setOnClickListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View v) {
        SharedPreferences.Editor ed = mSettings.edit();
        ed.putString(Settings.APP_PREFERENCES_BASE_URL, editTextBaseUrl.getText().toString());
        ed.putString(Settings.APP_PREFERENCES_PATH_URL, editTextPathUrl.getText().toString());
        ed.commit();
        ed.apply();
    }
}
