package com.example.gideonmanurung.sbmptnapps;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.gideonmanurung.sbmptnapps.api.APIProject;
import com.example.gideonmanurung.sbmptnapps.api.RESTClient;
import com.example.gideonmanurung.sbmptnapps.model.ModelPengumuman;
import com.example.gideonmanurung.sbmptnapps.model.ModelUser;

import java.util.List;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Splashscreen extends AppCompatActivity {
    Context myContext;
    ProgressDialog progressDialog;
    APIProject apiProject;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        myContext = getApplicationContext();
        progressDialog = ProgressDialog.show(Splashscreen.this,"Loading", "Connecting to server",true);

        try {
            Realm.init(myContext);
            realm = Realm.getDefaultInstance();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), e.getMessage(),Toast.LENGTH_LONG).show();
        }

        apiProject = RESTClient.get();
        Call<List<ModelUser>> callUser = apiProject.getAllUser();
        callUser.enqueue(new Callback<List<ModelUser>>() {
            @Override
            public void onResponse(Call<List<ModelUser>> call, Response<List<ModelUser>> response) {
                if(response.isSuccessful()){
                    final List<ModelUser> allUser = response.body();
                    final int jumlahData = allUser.size();
                    if(jumlahData>0){
                        try {
                            realm.executeTransaction(new Realm.Transaction() {
                                @Override
                                public void execute(Realm realm) {
                                    for(int i=0;i<jumlahData;i++){
                                        ModelUser u = allUser.get(i);
                                        int idUser = u.getId_user();
                                        ModelUser user = realm.createObject(ModelUser.class, idUser);
                                        user.setEmail(u.getEmail());
                                        user.setNama(u.getNama());
                                        user.setPassword(u.getPassword());
                                        user.setUsername(u.getUsername());
                                    }
                                }
                            });
                        }catch (Exception e){
                            Toast.makeText(myContext, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                        finally {
                            //realm.close();
                        }
                    }else {
                        Toast.makeText(myContext,"Data Tidak Tersedia" , Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Log.e("Error Code "+response.code(), "Message "+response.message());
                }
            }

            @Override
            public void onFailure(Call<List<ModelUser>> call, Throwable t) {
                Toast.makeText(myContext,"On Response Failure", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });

        Call<List<ModelPengumuman>> callPengumuman = apiProject.getAllPengumuman();
        callPengumuman.enqueue(new Callback<List<ModelPengumuman>>() {
            @Override
            public void onResponse(Call<List<ModelPengumuman>> call, Response<List<ModelPengumuman>> response) {
                if(response.isSuccessful()){
                    final List<ModelPengumuman> allPengumuman = response.body();
                    final int jumlahData = allPengumuman.size();
                    if(jumlahData>0){
                        try {
                            realm.executeTransaction(new Realm.Transaction() {
                                @Override
                                public void execute(Realm realm) {
                                    for(int i=0;i<jumlahData;i++){
                                        ModelPengumuman p = allPengumuman.get(i);
                                        int idPengumuman = p.getIdPengumuman();
                                        ModelPengumuman pengumuman = realm.createObject(ModelPengumuman.class, idPengumuman);
                                        pengumuman.setJudulPengumuman(p.getJudulPengumuman());
                                        pengumuman.setDate(p.getDate());
                                        pengumuman.setIsi(p.getIsi());
                                        pengumuman.setImage(p.getImage());
                                        Toast.makeText(myContext, "Pengumuman "+p.getJudulPengumuman(),Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                        }catch (Exception e){
                            Toast.makeText(myContext, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                        finally {
                            //realm.close();
                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent loginIntent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(loginIntent);
                                finish();
                            }
                        }, 3000);
                    }else {
                        Toast.makeText(myContext,"Data Tidak Tersedia" , Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                }else {
                    Log.e("Error Code "+response.code(), "Message "+response.message());
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<List<ModelPengumuman>> call, Throwable t) {
                Toast.makeText(myContext,"On Response Failure", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }
}
