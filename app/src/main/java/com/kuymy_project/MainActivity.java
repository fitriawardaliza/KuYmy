package com.kuymy_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import views.MenuUtama;

public class MainActivity extends AppCompatActivity {

    Button btnClickHere;
    EditText editTextNama, editTextNumber;
    String nama,no; // Variabel untuk menampung hasil nama, dan no.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnClickHere = (Button) findViewById(R.id.btnClickHere);
        editTextNama     = (EditText) findViewById(R.id.editTextNama);
        editTextNumber      = (EditText) findViewById(R.id.editTextNumber);

        btnClickHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nama = editTextNama.getText().toString();
                no = editTextNumber.getText().toString();

                Intent i = new Intent(MainActivity.this,MenuUtama.class);

                if(nama.equals("") ){
                    Toast.makeText(MainActivity.this, "Nama  tidak boleh kosong !", Toast.LENGTH_LONG).show();
                }else if (no.equals("")) {
                    Toast.makeText(MainActivity.this, "Nomor meja tidak boleh kosong !", Toast.LENGTH_LONG).show();
                }else{
                    i.putExtra("nama",nama);
                    i.putExtra("no",no);
                    startActivity(i);
                }


            }
        });
    }
}