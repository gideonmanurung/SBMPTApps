package com.example.gideonmanurung.sbmptnapps;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;

import com.example.gideonmanurung.sbmptnapps.adapter.SoaltpaAdapter;
import com.example.gideonmanurung.sbmptnapps.model.ModelSoalTPA;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SoaltpaActivity extends AppCompatActivity {
    private DatabaseReference mRootRef;
    private ListView listView;
    private SoaltpaAdapter soaltpaAdapter;
    private Button btnSelesai;
    private RadioButton radioButton0;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;

    private LinearLayoutManager linearLayoutManager;
    private List<ModelSoalTPA> allSoalTpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soaltpa);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView = (ListView) findViewById(R.id.list_soal_tpa);
        btnSelesai = (Button)findViewById(R.id.btnSelesai);
        radioButton0 = (RadioButton) findViewById(R.id.radio0);
        radioButton1 = (RadioButton) findViewById(R.id.radio1);
        radioButton2 = (RadioButton) findViewById(R.id.radio2);
        radioButton3 = (RadioButton) findViewById(R.id.radio3);

        allSoalTpa = new ArrayList<ModelSoalTPA>();
        mRootRef = FirebaseDatabase.getInstance().getReference();
        ValueEventListener soalTpaListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                getAllSoalTpa(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        mRootRef.child("tpa").addValueEventListener(soalTpaListener);

        btnSelesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioButton0.isChecked()){

                }
            }
        });
    }

    private void getAllSoalTpa(DataSnapshot dataSnapshot){
        for(DataSnapshot singleSnapshot : dataSnapshot.getChildren()){
            ModelSoalTPA m = singleSnapshot.getValue(ModelSoalTPA.class);
            allSoalTpa.add(m);
            soaltpaAdapter = new SoaltpaAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,allSoalTpa);
            listView.setAdapter(soaltpaAdapter);
        }
    }

}
