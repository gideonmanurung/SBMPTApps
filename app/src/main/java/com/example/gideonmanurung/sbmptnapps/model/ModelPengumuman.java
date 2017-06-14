package com.example.gideonmanurung.sbmptnapps.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Gideon Manurung on 5/23/2017.
 */

public class ModelPengumuman extends RealmObject{
    @PrimaryKey
    private int idPengumuman;
    private String judulPengumuman;
    private String isi;
    private String date;
    private String image;

    public ModelPengumuman(){}

    public ModelPengumuman(int idPengumuman, String judulPengumuman, String isi, String date, String image) {
        this.idPengumuman = idPengumuman;
        this.judulPengumuman = judulPengumuman;
        this.isi = isi;
        this.date = date;
        this.image = image;
    }

    public int getIdPengumuman() {
        return idPengumuman;
    }

    public void setIdPengumuman(int idPengumuman) {
        this.idPengumuman = idPengumuman;
    }

    public String getJudulPengumuman() {
        return judulPengumuman;
    }

    public void setJudulPengumuman(String judulPengumuman) {
        this.judulPengumuman = judulPengumuman;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
