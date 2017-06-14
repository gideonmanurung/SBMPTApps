package com.example.gideonmanurung.sbmptnapps.model;

/**
 * Created by Gideon Manurung on 5/23/2017.
 */

public class ModelSoalSoshum {
    private int kode_soal_soshum;
    private String soal_soshum;
    private String pilihan_a;
    private String pilihan_b;
    private String pilihan_c;
    private String pilihan_d;

    public ModelSoalSoshum(){}

    public ModelSoalSoshum(int kode_soal_soshum, String soal_soshum, String pilihan_a, String pilihan_b, String pilihan_c, String pilihan_d) {
        this.kode_soal_soshum = kode_soal_soshum;
        this.soal_soshum = soal_soshum;
        this.pilihan_a = pilihan_a;
        this.pilihan_b = pilihan_b;
        this.pilihan_c = pilihan_c;
        this.pilihan_d = pilihan_d;
    }

    public int getKode_soal_soshum() {
        return kode_soal_soshum;
    }

    public void setKode_soal_soshum(int kode_soal_soshum) {
        this.kode_soal_soshum = kode_soal_soshum;
    }

    public String getSoal_soshum() {
        return soal_soshum;
    }

    public void setSoal_soshum(String soal_soshum) {
        this.soal_soshum = soal_soshum;
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
}
