package views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.kuymy_project.R;

import java.util.ArrayList;

import data.DataPesanan;
import data.DatabaseHelper;

public class DaftarMinumanActivity extends AppCompatActivity {

    private DataPesanan db;
    private SQLiteDatabase database;
    private DatabaseHelper dbhelper;

    private ArrayList<String> nim;
    private ArrayList<String> nama;
    private ArrayList<String> jurusan;

    private CardView cardView;
    private Button editButton, deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_minuman);

        //        DaftarMinuman.this.deleteDatabase("pesanan.db");
        db = new DataPesanan(this);
        db.open();

        cardView = (CardView) findViewById(R.id.cardView1);
        CustomAdapter customAdapter = new CustomAdapter(DaftarMinumanActivity.this, db.getAllNIM(), db.getAllNama(), db.getAllJurusan());
        /*cardView.setAdapter(customAdapter);*/

        db.close();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DaftarMinumanActivity.this, Pesan.class));
            }
        });
    }

}