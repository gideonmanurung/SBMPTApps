package com.example.gideonmanurung.sbmptnapps.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.gideonmanurung.sbmptnapps.R;
import com.example.gideonmanurung.sbmptnapps.model.ModelPengumuman;

import java.util.List;

/**
 * Created by Gideon Manurung on 5/24/2017.
 */

public class PengumumanAdapter extends ArrayAdapter<ModelPengumuman> {
    private List<ModelPengumuman> pengumuman;
    Context context;
    private LayoutInflater mInflater;

    static class Holder{
        public TextView tvJudulPengumuman;
        public TextView tvTanggal;
        public TextView tvIsi;
    }

    public PengumumanAdapter(Context context , int txtViewResourceId , List<ModelPengumuman> pengumuman){
        super(context,txtViewResourceId,pengumuman);
        this.context= context;
        this.pengumuman = pengumuman;
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ModelPengumuman m = getItem(position);
        Holder viewHolder;
        if(convertView==null){
            viewHolder = new Holder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.custom_pengumuman,parent,false);
            viewHolder.tvJudulPengumuman = (TextView) convertView.findViewById(R.id.tvJudulPengumuman);
            viewHolder.tvTanggal = (TextView) convertView.findViewById(R.id.tvTanggal);
            viewHolder.tvIsi = (TextView) convertView.findViewById(R.id.tvIsi);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (Holder) convertView.getTag();
        }
        viewHolder.tvJudulPengumuman.setText(m.getJudulPengumuman());
        viewHolder.tvTanggal.setText(m.getDate());
        viewHolder.tvIsi.setText(m.getIsi());

        return convertView;
    }
}
