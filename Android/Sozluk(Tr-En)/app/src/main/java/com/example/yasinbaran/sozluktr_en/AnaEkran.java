package com.example.yasinbaran.sozluktr_en;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;


public class AnaEkran extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_ekran);
    }


    public void buttonKK(View view) {
        startActivity(new Intent(AnaEkran.this,KelimeKayit.class));
    }

    public void buttonKA(View view) {
        startActivity(new Intent(AnaEkran.this,KelimeAra.class));
    }

    public void buttonKH(View view) { startActivity(new Intent(AnaEkran.this,TercihActivity.class)); }
}
