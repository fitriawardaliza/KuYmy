package views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.kuymy_project.R;

public class ListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
    }

    public void Pesan(View view) {
        Intent intent = new Intent(ListView.this, PesananBerhasil.class);
        startActivity(intent);
    }

    public void Ubah(View view) {
        Intent intent = new Intent(ListView.this, UpdatePesanan.class);
        startActivity(intent);
    }
}