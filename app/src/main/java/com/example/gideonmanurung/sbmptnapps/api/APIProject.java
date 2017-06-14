package com.example.gideonmanurung.sbmptnapps.api;

import com.example.gideonmanurung.sbmptnapps.model.ModelPengumuman;
import com.example.gideonmanurung.sbmptnapps.model.ModelUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Gideon Manurung on 5/22/2017.
 */

public interface APIProject {
    @POST("/user/all")
    Call<List<ModelUser>> getAllUser();

    @POST("/pengumuman/all")
    Call<List<ModelPengumuman>> getAllPengumuman();

    @POST("/user/createNewUserFromMobile")
    Call<ModelUser> registerUser(@Path("nama") String nama , @Path("email") String email , @Path("username") String username, @Path("password") String password);
}
