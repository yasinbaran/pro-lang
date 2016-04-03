package com.example.yasinbaran.sozluktr_en;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MyService extends Service {
    Timer timer;
    Handler handler;
    Veri_Tabani db;
    String DakikaBilgisi;
    int b;
    public  MyService(){}

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        SharedPreferences preferences = getSharedPreferences("Preferences",MODE_PRIVATE);
        DakikaBilgisi = preferences.getString("hatirlatici_suresi","0");
        b = getZaman();
        Toast.makeText(this,"Hatırlatıcı Başlatıldı",Toast.LENGTH_SHORT).show();
        timer = new Timer();
        handler = new Handler(getMainLooper());
       try{
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Data();
            }
        }, 0,b);
    }catch (Exception e){
            Toast.makeText(MyService.this,"Veri Tabanı Hatası!",Toast.LENGTH_SHORT).show();
        }
    }



    @Override
    public void onDestroy() {
        timer.cancel();
        Toast.makeText(this,"Hatırlatıcı Kapatıldı",Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    public void Data(){
        db= new Veri_Tabani(MyService.this);
        db.getReadableDatabase();
        final String yaz = db.Kayitlar();
        db.close();
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MyService.this, yaz, Toast.LENGTH_SHORT).show();
            }
        });

    }
     public int  getZaman() {

        int a = Integer.parseInt(DakikaBilgisi);

            if (a == 1) {
                b = a*60*1000;

            }
            if (a == 2) {
                b = a * 60* 1000;

            }
            if (a == 3) {
                b = a * 60* 1000;
            }
            if (a ==4) {
                b = a * 60* 1000;
            }
            if (a == 5) {
                b = a * 60* 1000;
            }
            if (a == 6) {
                b = a * 60* 1000;
            }
            if (a ==7) {
                b = a * 60* 1000;
            }
            if (a ==8) {
                b = a * 60* 1000;
            }
            if (a ==9) {
                b = a * 60* 1000;
            }
            if (a ==10) {
                b = a * 60* 1000;
            }
         return b;

        }
}
