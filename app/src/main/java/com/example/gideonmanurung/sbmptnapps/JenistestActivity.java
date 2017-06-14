package com.example.gideonmanurung.sbmptnapps;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class JenistestActivity extends AppCompatActivity {
    private Context myContext;
    private Button btnTpa;
    private Button btnSaintek;
    private Button btnSoshum;
    private DatabaseReference mRootRef;
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jenistest);

        myContext = getApplicationContext();

        btnTpa = (Button) findViewById(R.id.btnTPA);
        btnTpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tpaIntent = new Intent(myContext, SoaltpaActivity.class);
                startActivity(tpaIntent);
            }
        });
        btnSaintek = (Button) findViewById(R.id.btnSaintek);
        btnSaintek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent saintekIntent = new Intent(myContext, SoalsaintekActivity.class);
                startActivity(saintekIntent);
            }
        });
        btnSoshum = (Button) findViewById(R.id.btnSoshum);
        btnSoshum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent soshumIntent = new Intent(myContext, SoalsoshumActivity.class);
                startActivity(soshumIntent);
            }
        });
    }
}
