package com.example.yasinbaran.sozluktr_en;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;


public class KelimeAra extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelime_ara);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_kelime_ara, menu);
        return true;
    }



    public void buttonTE(View view) {
        startActivity(new Intent(KelimeAra.this,TrEn.class));
    }

    public void buttonET(View view) {
        startActivity(new Intent(KelimeAra.this,EnTr.class));
    }
}
