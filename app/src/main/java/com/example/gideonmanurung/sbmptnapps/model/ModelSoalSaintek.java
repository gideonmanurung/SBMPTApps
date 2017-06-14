package com.example.gideonmanurung.sbmptnapps.model;

/**
 * Created by Gideon Manurung on 5/23/2017.
 */

public class ModelSoalSaintek {
    private int kode_soal_saintek;
    private String soal_saintek;
    private String gambar;
    private String pilihan_a;
    private String pilihan_b;
    private String pilihan_c;
    private String pilihan_d;
    private String jawaban;

    public ModelSoalSaintek(){}

    public ModelSoalSaintek(int kode_soal_saintek, String soal_saintek, String gambar, String pilihan_a, String pilihan_b, String pilihan_c, String pilihan_d, String jawaban) {
        this.kode_soal_saintek = kode_soal_saintek;
        this.soal_saintek = soal_saintek;
        this.gambar = gambar;
        this.pilihan_a = pilihan_a;
        this.pilihan_b = pilihan_b;
        this.pilihan_c = pilihan_c;
        this.pilihan_d = pilihan_d;
        this.jawaban = jawaban;
    }

    public int getKode_soal_saintek() {
        return kode_soal_saintek;
    }

    public void setKode_soal_saintek(int kode_soal_saintek) {
        this.kode_soal_saintek = kode_soal_saintek;
    }

    public String getSoal_saintek() {
        return soal_saintek;
    }

    public void setSoal_saintek(String soal_saintek) {
        this.soal_saintek = soal_saintek;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getPilihan_a() {
        return pilihan_a;
    }

    public void setPilihan_a(String pilihan_a) {
        this.pilihan_a = pilihan_a;
    }

    public String getPilihan_b() {
        return pilihan_b;
    }

    public void setPilihan_b(String pilihan_b) {
        this.pilihan_b = pilihan_b;
    }

    public String getPilihan_c() {
        return pilihan_c;
    }

    public void setPilihan_c(String pilihan_c) {
        this.pilihan_c = pilihan_c;
    }

    public String getPilihan_d() {
        return pilihan_d;
    }

    public void setPilihan_d(String pilihan_d) {
        this.pilihan_d = pilihan_d;
    }

    public String getJawaban() {
        return jawaban;
    }

    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
    }
}
