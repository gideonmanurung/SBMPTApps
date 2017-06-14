package com.example.gideonmanurung.sbmptnapps.model;

/**
 * Created by Gideon Manurung on 5/23/2017.
 */

public class ModelSoalTPA {
    private int kode_soal_tpa;
    private String soal_tpa;
    private int pilihan_a;
    private int pilihan_b;
    private int pilihan_c;
    private int pilihan_d;
    private int jawaban;

    public ModelSoalTPA(){}

    public ModelSoalTPA(int kode_soal_tpa, String soal_tpa, int pilihan_a, int pilihan_b, int pilihan_c, int pilihan_d, int jawaban) {
        this.kode_soal_tpa = kode_soal_tpa;
        this.soal_tpa = soal_tpa;
        this.pilihan_a = pilihan_a;
        this.pilihan_b = pilihan_b;
        this.pilihan_c = pilihan_c;
        this.pilihan_d = pilihan_d;
        this.jawaban = jawaban;
    }

    public int getKode_soal_tpa() {
        return kode_soal_tpa;
    }

    public void setKode_soal_tpa(int kode_soal_tpa) {
        this.kode_soal_tpa = kode_soal_tpa;
    }

    public String getSoal_tpa() {
        return soal_tpa;
    }

    public void setSoal_tpa(String soal_tpa) {
        this.soal_tpa = soal_tpa;
    }

    public int getPilihan_a() {
        return pilihan_a;
    }

    public void setPilihan_a(int pilihan_a) {
        this.pilihan_a = pilihan_a;
    }

    public int getPilihan_b() {
        return pilihan_b;
    }

    public void setPilihan_b(int pilihan_b) {
        this.pilihan_b = pilihan_b;
    }

    public int  getPilihan_c() {
        return pilihan_c;
    }

    public void setPilihan_c(int pilihan_c) {
        this.pilihan_c = pilihan_c;
    }

    public int getPilihan_d() {
        return pilihan_d;
    }

    public void setPilihan_d(int pilihan_d) {
        this.pilihan_d = pilihan_d;
    }

    public int getJawaban() {
        return jawaban;
    }

    public void setJawaban(int jawaban) {
        this.jawaban = jawaban;
    }
}
