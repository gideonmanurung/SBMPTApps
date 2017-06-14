package com.example.gideonmanurung.sbmptnapps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gideonmanurung.sbmptnapps.adapter.PengumumanAdapter;
import com.example.gideonmanurung.sbmptnapps.model.ModelPengumuman;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class PengumumanActivity extends AppCompatActivity {
    private ListView listView;
    private PengumumanAdapter pengumumanAdapter;
    private Realm realm;
    private LinearLayoutManager linearLayoutManager;
    private List<ModelPengumuman> allPengumuman = new ArrayList<ModelPengumuman>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengumuman);
        realm = Realm.getDefaultInstance();
        listView = (ListView) findViewById(R.id.listPengumuman);
        RealmResults<ModelPengumuman> allPengumumanRealm = realm.where(ModelPengumuman.class).findAll();
        for(ModelPengumuman m : allPengumumanRealm){
            allPengumuman.add(m);
        }
        pengumumanAdapter = new PengumumanAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,allPengumuman);
        listView.setAdapter(pengumumanAdapter);
        AdView mAdView = (AdView) findViewById(R.id.addView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}
