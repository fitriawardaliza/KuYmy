package views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kuymy_project.R;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import data.DataPesanan;
import data.DataPesanan;
import data.Pesanan;

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> nim;
    ArrayList<String> nama;
    ArrayList<String> jurusan;
    LayoutInflater inflter;
    private DataPesanan db;

    Button editButton, deleteButton;

    public CustomAdapter(Context applicationContext, ArrayList<String> nim, ArrayList<String> nama, ArrayList<String> jurusan) {
        this.context = applicationContext;
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return nim.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflter.inflate(R.layout.activity_list_view, parent, false);

        TextView nomorTV = (TextView) convertView.findViewById(R.id.nomor);
        nomorTV.setText(String.valueOf(position+1));

        TextView nimTV = (TextView) convertView.findViewById(R.id.nim);
        nimTV.setText(nim.get(position));

        TextView namaTV = (TextView) convertView.findViewById(R.id.nama);
        namaTV.setText(nama.get(position));

        TextView jurusanTV = (TextView) convertView.findViewById(R.id.jurusan);
        jurusanTV.setText(jurusan.get(position));

        editButton = (Button) convertView.findViewById(R.id.editButton);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdatePesanan.class);

                intent.putExtra("nim", getNIM(position));
                intent.putExtra("nama", getNama(position));
                intent.putExtra("jurusan", getJurusan(position));

//                Toast.makeText(context, "Nim: " + getNIM(position) + "\n Nama: " + getNama(position), Toast.LENGTH_LONG).show();
                context.startActivity(intent);
            }
        });

        deleteButton = (Button) convertView.findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = new DataPesanan(context);
                db.open();
                db.detelePesanan(getNIM(position));
                Toast.makeText(context, "Data deleted!", Toast.LENGTH_LONG).show();
                db.close();
                Intent intent = new Intent(context, ListView.class);
                context.startActivity(intent);
            }
        });

        return convertView;
    }

    public String getNIM(int position) {
        return nim.get(position);
    }

    public String getNama(int position) {
        return nama.get(position);
    }

    public String getJurusan(int position) {
        return jurusan.get(position);
    }
}
