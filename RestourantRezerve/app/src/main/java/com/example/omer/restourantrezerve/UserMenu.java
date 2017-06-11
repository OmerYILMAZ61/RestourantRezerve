package com.example.omer.restourantrezerve;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.lang.ref.SoftReference;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserMenu extends AppCompatActivity {

    CharSequence secilen;
    Spinner spUserMenuMasaDurumu;
    ListView lVUserMenuMasalar;
    String[] masalar = {"masa1", "masa2", "masa3", "masa4", "masa5", "masa6", "masa7"};
    List<String>  bosMasalar =new ArrayList<>();

    List<String> doluMasalar = new ArrayList<>();
    List<String> goster = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_menu);


        spUserMenuMasaDurumu = (Spinner) findViewById(R.id.spUserMenuMasaDurumu);
        lVUserMenuMasalar = (ListView) findViewById(R.id.lVUserMenuMasalar);

        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.BosDolu, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spUserMenuMasaDurumu.setAdapter(adapter);

        for (int i = 0; i < masalar.length ; i++) {
            bosMasalar.add(masalar[i]);
        }

        spUserMenuMasaDurumu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                secilen = spUserMenuMasaDurumu.getItemAtPosition(position).toString();
                UserMenu.this.setTitle(secilen);
                bindList(secilen);
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        lVUserMenuMasalar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, final int position, long id) {
                if (secilen.equals("Boş Masalar")) {

                    AlertDialog.Builder dlg = new AlertDialog.Builder(UserMenu.this,
                            android.R.style.Theme_Holo_Dialog);

                    dlg.setTitle("Merhaba");
                    dlg.setMessage(lVUserMenuMasalar.getItemAtPosition(position).toString() + "e Rezervasyon yapmak istiyorumusunuz");

                    dlg.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            doluMasalar.add(lVUserMenuMasalar.getItemAtPosition(position).toString());
                            bosMasalar.remove(position);
                            bindList(secilen);
                        }
                    });

                    dlg.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });

                    dlg.show();
                }else if(secilen.equals("Dolu Masalar")){

                    AlertDialog.Builder dlg = new AlertDialog.Builder(UserMenu.this,
                            android.R.style.Theme_Holo_Dialog);

                    dlg.setTitle("Merhaba");
                    dlg.setMessage(lVUserMenuMasalar.getItemAtPosition(position).toString() + "e Rezervasyonu iptal etmek istiyorumusunuz");

                    dlg.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            bosMasalar.add(lVUserMenuMasalar.getItemAtPosition(position).toString());
                            doluMasalar.remove(position);
                            bindList(secilen);
                        }
                    });

                    dlg.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });

                    dlg.show();
                }
            }
        });


    }

    private void bindList(CharSequence secilen) {


        if (secilen.equals("Boş Masalar")) {
            goster = bosMasalar;
        } else if (secilen.equals("Dolu Masalar")) {
            goster = doluMasalar;
        }
        ArrayAdapter<String>  adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, goster);

        lVUserMenuMasalar.setAdapter(adapter);

    }
}
