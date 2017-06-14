package com.example.gideonmanurung.sbmptnapps;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnTest;
    private Button btnPengumuman;
    private Button btnAboutUs;
    private Context myContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myContext = getApplicationContext();

        btnTest = (Button) findViewById(R.id.btnTest);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent testIntent = new Intent(myContext, JenistestActivity.class);
                startActivity(testIntent);
            }
        });
        btnPengumuman = (Button) findViewById(R.id.btnPengumuman);
        btnPengumuman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pengumumanIntent = new Intent(myContext, PengumumanActivity.class);
                startActivity(pengumumanIntent);
            }
        });
        btnAboutUs = (Button) findViewById(R.id.btnAbout);
        btnAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aboutIntent = new Intent(myContext, AboutusActivity.class);
                startActivity(aboutIntent);
            }
        });
    }
}
