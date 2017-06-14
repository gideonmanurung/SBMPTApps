package com.example.gideonmanurung.sbmptnapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gideonmanurung.sbmptnapps.api.APIProject;
import com.example.gideonmanurung.sbmptnapps.api.RESTClient;
import com.example.gideonmanurung.sbmptnapps.model.ModelUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    private EditText etNama;
    private EditText etEmail;
    private EditText etUsername;
    private EditText etPassword;
    private Button btnSubmit;
    private Button btnCancel;
    APIProject apiProject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etNama = (EditText) findViewById(R.id.et_nama);
        etEmail = (EditText) findViewById(R.id.et_email);
        etUsername = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = etNama.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                apiProject = RESTClient.get();
                Call<ModelUser> callUser = apiProject.registerUser(nama,email,username,password);
                callUser.enqueue(new Callback<ModelUser>() {
                    @Override
                    public void onResponse(Call<ModelUser> call, Response<ModelUser> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Register is Succesfully", Toast.LENGTH_SHORT).show();
                            Intent loginIntent = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(loginIntent);
                        }
                    }

                    @Override
                    public void onFailure(Call<ModelUser> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"Register is Failed", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(loginIntent);
            }
        });
    }
}
