package com.example.gideonmanurung.sbmptnapps.model;

import java.util.List;

/**
 * Created by Gideon Manurung on 5/23/2017.
 */

public class SbmptnApps {
    private List<ModelSoalSaintek> sainteks;
    private List<ModelSoalSoshum> soshums;
    private List<ModelSoalTPA> tpa;

    public SbmptnApps(){}

    public SbmptnApps(List<ModelSoalSaintek> sainteks, List<ModelSoalSoshum> soshums, List<ModelSoalTPA> tpa) {
        this.sainteks = sainteks;
        this.soshums = soshums;
        this.tpa = tpa;
    }

    public List<ModelSoalSaintek> getSainteks() {
        return sainteks;
    }

    public void setSainteks(List<ModelSoalSaintek> sainteks) {
        this.sainteks = sainteks;
    }

    public List<ModelSoalSoshum> getSoshums() {
        return soshums;
    }

    public void setSoshums(List<ModelSoalSoshum> soshums) {
        this.soshums = soshums;
    }

    public List<ModelSoalTPA> getTpa() {
        return tpa;
    }

    public void setTpa(List<ModelSoalTPA> tpa) {
        this.tpa = tpa;
    }
}
