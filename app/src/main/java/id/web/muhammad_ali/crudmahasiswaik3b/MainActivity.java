package id.web.muhammad_ali.crudmahasiswaik3b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import id.web.muhammad_ali.crudmahasiswaik3b.adapter.MahasiswaAdpater;
import id.web.muhammad_ali.crudmahasiswaik3b.model.Mahasiswa;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Coba gambar source dinamis
        ImageView ivCobaGambar = (ImageView) findViewById(R.id.iv_coba_gambar);

        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8){
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        try {
            URL url = new URL("https://picsum.photos/200/300?image=1");
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            ivCobaGambar.setImageBitmap(bmp);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //1. Data
        String[] nama = new String[]{"ali","muhammad","maksum","reinka"};

        Mahasiswa mahasiswa1=new Mahasiswa();
        mahasiswa1.setNama("ali");
        mahasiswa1.setNim("3.34.15.1.18");
        mahasiswa1.setEmail("alimasum2830@gmail.com");
        mahasiswa1.setFoto("https://picsum.photos/200/300?image=1");

        Mahasiswa mahasiswa2 =new Mahasiswa(
                "muhammad",
                "3.34.15.1.28",
                "muhammad@rasul.com",
                "https://picsum.photos/200/300?image=2"
        );

        ArrayList<Mahasiswa> mahasiswas = new ArrayList<>();
        mahasiswas.add(mahasiswa1);
        mahasiswas.add(mahasiswa2);

        //2. Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, nama);

        MahasiswaAdpater mahasiswaAdpater = new MahasiswaAdpater(this,
                R.layout.item_mahasiswa, mahasiswas);

        //3. Activity
        ListView lvDaftarNama = (ListView) findViewById(R.id.lv_daftar_nama);
        lvDaftarNama.setAdapter(mahasiswaAdpater);

    }
}
