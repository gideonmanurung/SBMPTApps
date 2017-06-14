package com.example.gideonmanurung.sbmptnapps;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.example.gideonmanurung.sbmptnapps.adapter.SoalsoshumAdapter;
import com.example.gideonmanurung.sbmptnapps.model.ModelSoalSoshum;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SoalsoshumActivity extends AppCompatActivity {
    private DatabaseReference mRootRef;
    private ListView listView;
    private SoalsoshumAdapter soalsoshumAdapter;

    private LinearLayoutManager linearLayoutManager;
    private List<ModelSoalSoshum> allSoalSoshum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soalsoshum);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.list_soal_soshum);

        allSoalSoshum = new ArrayList<ModelSoalSoshum>();
        mRootRef = FirebaseDatabase.getInstance().getReference();
        ValueEventListener soalTpaListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                getAllSoalSoshum(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        mRootRef.child("soshums").addValueEventListener(soalTpaListener);
    }

    private void getAllSoalSoshum(DataSnapshot dataSnapshot){
        for(DataSnapshot singleSnapshot : dataSnapshot.getChildren()){
            ModelSoalSoshum m = singleSnapshot.getValue(ModelSoalSoshum.class);
            allSoalSoshum.add(m);
            soalsoshumAdapter = new SoalsoshumAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,allSoalSoshum);
            listView.setAdapter(soalsoshumAdapter);
        }
    }
}
