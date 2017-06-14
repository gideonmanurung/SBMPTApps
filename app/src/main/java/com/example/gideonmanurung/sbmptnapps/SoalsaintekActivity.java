package com.example.gideonmanurung.sbmptnapps;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.example.gideonmanurung.sbmptnapps.adapter.SoalsaintekAdapter;
import com.example.gideonmanurung.sbmptnapps.model.ModelSoalSaintek;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SoalsaintekActivity extends AppCompatActivity {
    private DatabaseReference mRootRef;
    private ListView listView;
    private SoalsaintekAdapter soalsaintekAdapter;

    private LinearLayoutManager linearLayoutManager;
    private List<ModelSoalSaintek> allSoalSaintek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soalsaintek);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.list_soal_saintek);

        allSoalSaintek = new ArrayList<>();
        mRootRef = FirebaseDatabase.getInstance().getReference();
        ValueEventListener soalTpaListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                getAllSoalSaintek(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        mRootRef.child("sainteks").addValueEventListener(soalTpaListener);
    }

    private void getAllSoalSaintek(DataSnapshot dataSnapshot){
        for(DataSnapshot singleSnapshot : dataSnapshot.getChildren()){
            ModelSoalSaintek m = singleSnapshot.getValue(ModelSoalSaintek.class);
            allSoalSaintek.add(m);
            soalsaintekAdapter = new SoalsaintekAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,allSoalSaintek);
            listView.setAdapter(soalsaintekAdapter);
        }
    }
}
