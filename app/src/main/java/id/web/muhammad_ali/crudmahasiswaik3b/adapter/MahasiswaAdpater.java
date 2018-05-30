package id.web.muhammad_ali.crudmahasiswaik3b.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import id.web.muhammad_ali.crudmahasiswaik3b.R;
import id.web.muhammad_ali.crudmahasiswaik3b.model.Mahasiswa;

/**
 * Created by newbye on 23/05/2018.
 */

public class MahasiswaAdpater extends ArrayAdapter<Mahasiswa> {
    public MahasiswaAdpater(@NonNull Context context,
                            @LayoutRes int resource,
                            @NonNull ArrayList<Mahasiswa> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_mahasiswa, parent, false);
        }

        Mahasiswa mahasiswa = getItem(position);

        TextView tvNama = (TextView) convertView.findViewById(R.id.tv_nama);
        tvNama.setText(mahasiswa.getNama());
        TextView tvNim = (TextView) convertView.findViewById(R.id.tv_nim);
        tvNim.setText(mahasiswa.getNim());
        TextView tvEmail = (TextView) convertView.findViewById(R.id.tv_email);
        tvEmail.setText(mahasiswa.getEmail());

        return convertView;
    }
}
