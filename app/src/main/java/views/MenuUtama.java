package views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.kuymy_project.MainActivity;
import com.kuymy_project.R;

public class MenuUtama extends AppCompatActivity {

    private TextView tvNama, tvNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);

        tvNama = findViewById(R.id.tv_nama);
        tvNo = findViewById(R.id.tv_no);

        Intent terima = getIntent();
        String terimaNama = terima.getStringExtra("nama");
        String terimaNo = terima.getStringExtra("no");

        tvNama.setText(terimaNama);
        tvNo.setText(terimaNo);
    }

    public void Makanan(View view) {
        Intent intent = new Intent(MenuUtama.this, DaftarMakananActivity.class);
        startActivity(intent);


    }

    public void Minuman(View view) {
        Intent intent = new Intent(MenuUtama.this, DaftarMinumanActivity.class);
        startActivity(intent);
    }

    public void Cemilan(View view) {
        Intent intent = new Intent(MenuUtama.this, DaftarCemilanActivity.class);
        startActivity(intent);
    }
}