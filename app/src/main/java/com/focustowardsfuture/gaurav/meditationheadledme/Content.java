package com.focustowardsfuture.gaurav.meditationheadledme;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Content {

    @SerializedName("pName")
    @Expose
    private String pName;

    @SerializedName("pEmail")
    @Expose
    private String pEmail;

    @SerializedName("pMobile")
    @Expose
    private String pMobile;

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpEmail() {
        return pEmail;
    }

    public void setpEmail(String pEmail) {
        this.pEmail = pEmail;
    }

    public String getpMobile() {
        return pMobile;
    }

    public void setpMobile(String pMobile) {
        this.pMobile = pMobile;
    }

    @Override
    public String toString() {
        return "Content{" +
                "pName='" + pName + '\'' +
                ", pEmail='" + pEmail + '\'' +
                ", pMobile='" + pMobile + '\'' +
                '}';
    }
}
