package com.example.yasinbaran.sozluktr_en;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

/**
 * Created by YasinBARAN on 20.4.2015.
 */
public class TercihActivity extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {
    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        addPreferencesFromResource(R.xml.ayarlar);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        preferences.registerOnSharedPreferenceChangeListener(this);

    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        String DkBilgisi = sharedPreferences.getString("hatirlatici_suresi","0");
        boolean Durum = sharedPreferences.getBoolean("hatirlatici",false);

        SharedPreferences preferences = getSharedPreferences("Preferences",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("hatirlatici_suresi",DkBilgisi);
        editor.commit();

        Intent Startintent = new Intent(TercihActivity.this,MyService.class);
        Intent ıntent = new Intent(TercihActivity.this,MyService.class);

        if(Durum==true){
            this.startService(Startintent);
        }else{
            this.stopService(ıntent);
        }
    }
}
