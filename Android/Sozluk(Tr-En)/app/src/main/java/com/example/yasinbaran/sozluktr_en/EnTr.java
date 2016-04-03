package com.example.yasinbaran.sozluktr_en;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class EnTr extends ActionBarActivity {
    EditText e1;
    TextView t1;
    Veri_Tabani db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_en_tr);
        e1= (EditText) findViewById(R.id.ETi);
        t1= (TextView) findViewById(R.id.TVt);
    }


    public void btnARA(View view) {
        String AranacakKelime = e1.getText().toString().toLowerCase().trim();
        if(AranacakKelime == null || AranacakKelime.matches("") ){
            Toast.makeText(this,"Aranacak Kelimeyi Giriniz",Toast.LENGTH_SHORT).show();
        }else {
            try {
                db = new Veri_Tabani(EnTr.this);
                String eldeEdileningilizceKelime = db.getIngilizceName(AranacakKelime);
                t1.setText(eldeEdileningilizceKelime.toUpperCase());
            }catch (Exception e){
                Toast.makeText(this,"Aradığınız Kelime Bulanamadı!",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
