package com.example.yasinbaran.sozluktr_en;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by YasinBARAN on 18.3.2015.
 */
public class Veri_Tabani extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "sozluk";
    public static final String TABLE_NAME = "kelimeler";
    public static final String COLOUMN_ID = "_id";
    public static final String COLOUMN_TURKCE ="turkce";
    public static final String COLOUMN_INGILIZCE ="ingilizce";
    public static final int DATABASE_VERSION=1;
    public static final String ORDER = "RANDOM() LIMIT 1";
    public  static final String[] COLOUMNS={COLOUMN_ID,COLOUMN_TURKCE,COLOUMN_INGILIZCE};
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + COLOUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLOUMN_TURKCE + " TEXT,"
            + COLOUMN_INGILIZCE + " TEXT" + ")";
    public static final String DATABASE_DROP = "DROP TABLE IF EXIST" + TABLE_NAME;

    public Veri_Tabani(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.w("DatabaseHelper","Veri Tabani"+oldVersion+"\'dan"+newVersion+"\'a güncelleniyor");
        db.execSQL(DATABASE_DROP);
        onCreate(db);
    }
    public void KayıtEkle(String T_kelime,String I_kelime){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(COLOUMN_TURKCE, T_kelime);
            values.put(COLOUMN_INGILIZCE, I_kelime);
            db.insert(TABLE_NAME, null, values);
            db.close();

    }
    public String getTurkceName(String turkce) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c =db.query(TABLE_NAME, COLOUMNS, COLOUMN_TURKCE +"= ?",
                new String[] {turkce}, null, null, null, null);
        if (c != null) {
            c.moveToFirst();
            String ingilizce = c.getString(2);
            return ingilizce;
        }
        return c.getString(2);

    }
    public String getIngilizceName(String ingilizce) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c =db.query(TABLE_NAME, COLOUMNS, COLOUMN_INGILIZCE +"= ?",
                new String[] {ingilizce}, null, null, null, null);
        if (c != null) {
            c.moveToFirst();
            String turkce = c.getString(1);
            return turkce;
        }
        return c.getString(1);

    }
    public void KayitSil(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLOUMN_ID + " =? ", new String[] { String.valueOf(id) });
        db.close();

    }
    public void KayitGuncelle(String kelime1,String kelime2,int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        //Bu methodda ise var olan veriyi g�ncelliyoruz(update)
        ContentValues values = new ContentValues();
        values.put(COLOUMN_TURKCE, kelime1);
        values.put(COLOUMN_INGILIZCE, kelime2);

        // updating row
        db.update(TABLE_NAME, values, COLOUMN_ID + " = ?",
                new String[] { String.valueOf(id) });
    }

    public  ArrayList<HashMap<String, String>> TumVerileriGoster(){

        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);
        ArrayList<HashMap<String, String>> verilist = new ArrayList<HashMap<String, String>>();

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> map = new HashMap<String, String>();
                for(int i=0; i<cursor.getColumnCount();i++)
                {
                    map.put(cursor.getColumnName(i), cursor.getString(i));
                }
                verilist.add(map);
            } while (cursor.moveToNext());
        }
        db.close();
        return verilist;
    }
    public void VerileriSil(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, null, null);
        db.close();
    }

    public String Kayitlar(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(TABLE_NAME,COLOUMNS,null,null,null,null, ORDER);
        String Kelimeler ="";

        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
            String turkce = c.getString(1);
            String ingilizce = c.getString(2);
            Kelimeler = turkce +"  -->  "+ ingilizce;
        }
        return Kelimeler;

    }


}
