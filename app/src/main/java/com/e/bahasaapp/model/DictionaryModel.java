package com.e.bahasaapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DictionaryModel {

    @SerializedName("indonesia")
    @Expose
    private String indonesia;
    @SerializedName("daerah")
    @Expose
    private String daerah;


    public DictionaryModel(String indonesia, String daerah) {
        this.indonesia = indonesia;
        this.daerah = daerah;
    }


    public String getIndonesia() {
        return indonesia;
    }

    public void setIndonesia(String indonesia) {
        this.indonesia = indonesia;
    }

    public String getDaerah() {
        return daerah;
    }

    public void setDaerah(String daerah) {
        this.daerah = daerah;
    }
}
