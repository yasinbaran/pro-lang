package com.example.yasinbaran.kredihesaplama;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.text.NumberFormat;
import java.util.Locale;
import android.widget.AdapterView.OnItemSelectedListener;


public class MainActivity extends Activity {

    Spinner spinner;
    EditText kredi_miktari;
    SeekBar seekBar;
    TextView vade;
    Button hesapla;
    TextView aylik_tutar;
    TextView toplam_tutar;
    TextView faiz_orani;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //xml ile bağlantı kurduk.

        spinner =(Spinner)findViewById(R.id.spinner);
        kredi_miktari=(EditText)findViewById(R.id.editText);
        seekBar=(SeekBar)findViewById(R.id.seekBar);
        vade=(TextView)findViewById(R.id.textView11);
        hesapla=(Button)findViewById(R.id.button);
        aylik_tutar=(TextView)findViewById(R.id.textView7);
        toplam_tutar=(TextView)findViewById(R.id.textView8);
        faiz_orani=(TextView)findViewById(R.id.textView10);

        //spinner'dan veri almak için, arrayadater ile spinneri dinledik.

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.planets_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //spinner'i dinledik, seçilen veri de ne yapılacağını belirttik.

        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //Spinner'da seçilen değerin pozisyonunu alıp, ona göre kredi miktarını yazdırdık ve seekbar da kredi türüne göre kaç aya kadar taksit yapılacağını belirttik.
                //Kredi verileri HSBC bank'ın güncel verilerinden alındı.

                switch(spinner.getSelectedItemPosition()){
                    case 1:faiz_orani.setText("1.67");seekBar.setMax(36);break;
                    case 2:faiz_orani.setText("1.25");seekBar.setMax(120);break;
                    case 3:faiz_orani.setText("1.39");seekBar.setMax(48);break;
                    case 4:faiz_orani.setText("1.45");seekBar.setMax(36);break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

               //seekbar'dan aldığımız veriyi vade'ye yazdırdık.
                vade.setText(String.valueOf(progress));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            protected Object clone() throws CloneNotSupportedException {
                return super.clone();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //Hesapla butonunu dinledik. Tıklanınca ne yapılacağını tanımladık.

        hesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Eğer spinner'dan veri seçilmediyse ekrana Kredi Türünü Seçiniz mesajı gönderdik.

                if(spinner.getSelectedItemPosition()==0){

                    Toast.makeText(getApplicationContext(),"Kredi Türünü Seçiniz", Toast.LENGTH_LONG).show();

                }

                else {
                    //Kremiktarına ilk önce sıfır değerini atadık. Bu method içerisinde global olması için yaptık. Eğer yapmasak try-catch'te yazdığımız için Taksit tutarı hesaplarken local olduğundan program hata verecektir.

                    double KrediMiktari=0;

                    //VadeSuresini vade textview'inden alıp vadesüresi değişkenine atadık.

                    double VadeSuresi = Double.valueOf(vade.getText().toString());

                    //Faiz oranını faiz_oarni textview'inden alıp FaizORani değişkenine atadık.

                    double FaizOrani = Double.valueOf(faiz_orani.getText().toString());

                    //Kullanıcının kredi miktarını girmeden hesaplamaya kalktığı zaman programımın durdurulmaması için try-catch ile kullanıcıya bilgi döndürdük.

                    try {
                        KrediMiktari = Double.valueOf(kredi_miktari.getText().toString());
                    }
                    catch(Exception e){
                        Toast.makeText(getApplicationContext(),"Lütfen kredi miktarını giriniz",Toast.LENGTH_LONG).show();
                    }

                    //Vade süresini kullaıcı seçmediğinde kullanıcıya bilgi mesajı döndürdük.

                    if(VadeSuresi==0) {
                        Toast.makeText(getApplicationContext(),"Lütfen vadeyi giriniz",Toast.LENGTH_LONG).show();
                    }
                    //Aylık ödenecek ve toplam ödenecek fiyatı hesapladık.

                    double TaksitTutari = (KrediMiktari*FaizOrani/100)/(1-(1/Math.pow((1+(FaizOrani/100)), VadeSuresi)));
                    double ToplamTutar = (TaksitTutari * VadeSuresi);

                    //Hesapladığımız değerleri textviewlere faormatlayıp yazdırdık.

                    aylik_tutar.setText(String.valueOf(NumberFormat.getNumberInstance(Locale.GERMAN).format(TaksitTutari))+" TL");
                    toplam_tutar.setText(String.valueOf(NumberFormat.getNumberInstance(Locale.GERMAN).format(ToplamTutar))+" TL");



                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
