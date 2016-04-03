package com.example.yasinbaran.sozluktr_en;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread girisekrani = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(3000);  //ekranda gösterileceği süreyi tanımladım. (3 saniye)
                    startActivity(new Intent(MainActivity.this,AnaEkran.class));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    finish();
                }

            }
        });
        girisekrani.start();
    }



}
