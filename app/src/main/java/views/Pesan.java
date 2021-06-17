package views;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.kuymy_project.MainActivity;
import com.kuymy_project.R;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import data.DataPesanan;
import data.Pesanan;

public class Pesan extends AppCompatActivity {
    private EditText editTextNIM, editTextNama, editTextJurusan;
    private Button buttonAdd;
    private DataPesanan db;
    private String nim, nama, jurusan;

    private final int REQUEST_CODE_GALLERY = 345;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan);

        editTextNIM = findViewById(R.id.editTextNIM);
        editTextNama = findViewById(R.id.editTextNama);
        editTextJurusan = findViewById(R.id.editTextJurusan);

        buttonAdd = findViewById(R.id.buttonAdd);


        db = new DataPesanan (Pesan.this);

        nim = getIntent().getStringExtra("nim");
        nama = getIntent().getStringExtra("nama");
        jurusan = getIntent().getStringExtra("jurusan");

        editTextNIM.setText(nim);
        editTextNama.setText(nama);
        editTextJurusan.setText(jurusan);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.open();
                db.addPesanan(new Pesanan(editTextNIM.getText().toString(), editTextNama.getText().toString(),editTextJurusan.getText().toString()));
//                db.addMahasiswa(editTextNIM.getText().toString(), editTextNama.getText().toString(), editTextJurusan.getText().toString());
                db.close();
                Toast.makeText(Pesan.this, "Data added!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Pesan.this, ListView.class);
                startActivity(intent);
            }
        });


    }
}