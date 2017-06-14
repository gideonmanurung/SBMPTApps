package com.example.gideonmanurung.sbmptnapps.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Gideon Manurung on 5/22/2017.
 */

public class ModelUser extends RealmObject{
    @PrimaryKey
    private int idUser;
    private String email;
    private String nama;
    private String password;
    private String username;

    public ModelUser(){}

    public ModelUser(int id_user, String email, String nama, String password, String username) {
        this.idUser = id_user;
        this.email = email;
        this.nama = nama;
        this.password = password;
        this.username = username;
    }

    public int getId_user() {
        return idUser;
    }

    public void setId_user(int id_user) {
        this.idUser = id_user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
