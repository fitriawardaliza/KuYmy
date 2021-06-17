package data;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.widget.ImageView;

import views.Pesan;

public class DataPesanan {
    private SQLiteDatabase database;
    private DatabaseHelper dbhelper;

    public DataPesanan(Context context) {
        dbhelper = new DatabaseHelper(context);
    }

    public void open() throws SQLException {
        database = dbhelper.getWritableDatabase();
    }

    public void close() {
        dbhelper.close();
    }

    public void addPesanan(Pesanan pesanan) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.KEY_NAMA, pesanan.getNama());
        values.put(DatabaseHelper.KEY_NIM, pesanan.getNim());
        values.put(DatabaseHelper.KEY_JURUSAN, pesanan.getJurusan());

        //inserting row
        database.insert(DatabaseHelper.TABLE_PESANAN, null, values);
    }

    public void updatePesanan(String nim, String nama, String jurusan) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.KEY_NIM, nim);
        values.put(DatabaseHelper.KEY_NAMA, nama);
        values.put(DatabaseHelper.KEY_JURUSAN, jurusan);

        database.update(DatabaseHelper.TABLE_PESANAN, values, "nim=?", new String[]{nim});
    }

    public void detelePesanan(String nim) {
        database.delete(DatabaseHelper.TABLE_PESANAN, "nim=?", new String[]{nim});
    }

    public ArrayList<String> getAllNIM() {
        ArrayList<String> listNIM = new ArrayList<String>();

        String allNIM = "SELECT nim FROM " + DatabaseHelper.TABLE_PESANAN;
        Cursor cursor = database.rawQuery(allNIM, null);

        if (cursor.moveToFirst()) {
            do {
                listNIM.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }

        cursor.close();
        return listNIM;
    }

    public ArrayList<String> getAllNama() {
        ArrayList<String> listNama = new ArrayList<String>();

        String allNama = "SELECT nama FROM " + DatabaseHelper.TABLE_PESANAN;
        Cursor cursor = database.rawQuery(allNama, null);

        if (cursor.moveToFirst()) {
            do {
                listNama.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }

        cursor.close();
        return listNama;
    }

    public ArrayList<String> getAllJurusan() {
        ArrayList<String> listJurusan = new ArrayList<String>();

        String allJurusan = "SELECT jurusan FROM " + DatabaseHelper.TABLE_PESANAN;
        Cursor cursor = database.rawQuery(allJurusan, null);

        if (cursor.moveToFirst()) {
            do {
                listJurusan.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }

        cursor.close();
        return listJurusan;
    }

    /*public ArrayList<byte[]> getAllImage() {
        ArrayList<byte[]> listImage = new ArrayList<byte[]>();

        String allImage = "SELECT foto FROM " + DatabaseHelper.TABLE_PESANAN;
        Cursor cursor = database.rawQuery(allImage, null);

        if (cursor.moveToFirst()) {
            do {
                listImage.add(cursor.getBlob(0));
            } while (cursor.moveToNext());
        }

        cursor.close();
        return listImage;
    }*/

    /*public List<Pesanan> getAllPesanan() {
        List<Pesanan> listPesanan = new ArrayList<Pesanan>();

        //select all data pesanan
        String allPesanan = "SELECT * FROM " + DatabaseHelper.TABLE_PESANAN;
        Cursor cursor = database.rawQuery(allPesanan, null);
    }*/



        //looping through all rows and adding to list
        /*if (cursor.moveToFirst()) {
            do {

                pesanan.setId(Integer.parseInt(cursor.getString(0)));
                pesanan.setNim(cursor.getString(1));
                pesanan.setNama(cursor.getString(2));
                pesanan.setJurusan(cursor.getString(3));

                //adding pesanan to the list
                listPesanan.add(pesanan);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return listPesanan;
    }*/

}

