package com.example.omer.restourantrezerve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editTextKAdi;
    EditText editTextSif;
    Button btnGir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextKAdi = (EditText) findViewById(R.id.edTKAdi);
        editTextSif = (EditText) findViewById(R.id.editTextSif);
        btnGir = (Button) findViewById(R.id.btnGir);

        btnGir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextKAdi.getText().toString().equals("sso")&&editTextSif.getText().toString().equals("123")){
                    Intent intIntent = new Intent(MainActivity.this,UserMenu.class);
                    intIntent.putExtra("etLoginName",editTextKAdi.getText().toString());
                    startActivity(intIntent);
                }
            }
        });



    }


}
