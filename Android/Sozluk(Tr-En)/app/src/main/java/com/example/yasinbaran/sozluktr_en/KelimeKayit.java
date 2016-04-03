package com.example.yasinbaran.sozluktr_en;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class KelimeKayit extends ActionBarActivity {
    EditText k1,k2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelime_kayit);
        k1 = (EditText) findViewById(R.id.KT);
        k2 = (EditText) findViewById(R.id.KI);
    }

    public void btnKayit(View view) {
        String turkce_kelime,ingilizce_kelime;
        turkce_kelime = k1.getText().toString().toLowerCase().trim();
        ingilizce_kelime = k2.getText().toString().toLowerCase().trim();

        if(turkce_kelime.matches("") || ingilizce_kelime.matches("") || turkce_kelime == null || ingilizce_kelime ==null){
            Toast.makeText(getApplicationContext(), "Tum Bilgileri Eksiksiz Doldurunuz", Toast.LENGTH_LONG).show();
        }
        else{
            try {
                Veri_Tabani db = new Veri_Tabani(getApplicationContext());
                db.KayıtEkle(turkce_kelime, ingilizce_kelime);
                db.close();
                Toast.makeText(getApplicationContext(), "Kelime Basariyla Eklendi.", Toast.LENGTH_LONG).show();
                k1.setText("");
                k2.setText("");
            }
            catch(Exception e){
                Toast.makeText(this,"Kelime Eklenemedi, Tekrar Deneyiniz.",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
