package com.example.gideonmanurung.sbmptnapps.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.gideonmanurung.sbmptnapps.R;
import com.example.gideonmanurung.sbmptnapps.model.ModelSoalSoshum;

import java.util.List;

/**
 * Created by Gideon Manurung on 5/23/2017.
 */

public class SoalsoshumAdapter extends ArrayAdapter<ModelSoalSoshum>{
    private List<ModelSoalSoshum> soshum;
    Context context;
    private LayoutInflater mInflater;

    static class Holder{
        public TextView soal_soshum;
        public RadioButton pilihan_a;
        public RadioButton pilihan_b;
        public RadioButton pilihan_c;
        public RadioButton pilihan_d;
    }

    public SoalsoshumAdapter(Context context , int txtViewResourceId , List<ModelSoalSoshum> soshum){
        super(context,txtViewResourceId,soshum);
        this.context= context;
        this.soshum = soshum;
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ModelSoalSoshum m = getItem(position);
        Holder viewHolder;
        if(convertView==null){
            viewHolder = new Holder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.tampilan_soal,parent,false);
            viewHolder.soal_soshum = (TextView) convertView.findViewById(R.id.textViewSoal);
            viewHolder.pilihan_a = (RadioButton) convertView.findViewById(R.id.radio0);
            viewHolder.pilihan_b = (RadioButton) convertView.findViewById(R.id.radio1);
            viewHolder.pilihan_c = (RadioButton) convertView.findViewById(R.id.radio2);
            viewHolder.pilihan_d = (RadioButton) convertView.findViewById(R.id.radio3);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (Holder) convertView.getTag();
        }
        viewHolder.soal_soshum.setText(m.getSoal_soshum());
        viewHolder.pilihan_a.setText(m.getPilihan_a());
        viewHolder.pilihan_b.setText(m.getPilihan_b());
        viewHolder.pilihan_c.setText(m.getPilihan_c());
        viewHolder.pilihan_d.setText(m.getPilihan_d());

        return convertView;
    }
}
