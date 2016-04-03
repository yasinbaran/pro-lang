package com.example.yasinbaran.sozluktr_en;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class TrEn extends ActionBarActivity {
    Veri_Tabani db;
    EditText e1;
    TextView e2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tr_en);
        e1 = (EditText) findViewById(R.id.TKelime);
        e2 = (TextView) findViewById(R.id.Ikelime);
    }

    public void btnAra(View view) {
       String AranacakKelime = e1.getText().toString().toLowerCase().trim();
        if(AranacakKelime==null || AranacakKelime.matches("")){
            Toast.makeText(this, "Aranacak Kelimeyi Giriniz", Toast.LENGTH_SHORT).show();
        }else {
            try {
                db = new Veri_Tabani(TrEn.this);
                String eldeEdilenTurkceKelime = db.getTurkceName(AranacakKelime);
                e2.setText(eldeEdilenTurkceKelime.toUpperCase());
            }catch (Exception e){
                Toast.makeText(this,"Aradığınız Kelime Bulunamadı!",Toast.LENGTH_SHORT).show();
            }

        }
    }
}
