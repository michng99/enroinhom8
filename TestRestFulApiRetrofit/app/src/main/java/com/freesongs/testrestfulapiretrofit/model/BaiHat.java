package com.freesongs.testrestfulapiretrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaiHat {

    @Expose
    @SerializedName("tenbaihat")
    String tenbaihat;

    @Expose
    @SerializedName("tacgia")
    String tacgia;

    @Expose
    @SerializedName("baihaturl")
    String baihaturl;

    @Expose
    @SerializedName("hinhanh")
    String hinhanh;

    @Expose
    @SerializedName("thoiluong")
    String thoiluong;

    public BaiHat(String tenbaihat, String tacgia, String baihaturl, String hinhanh, String thoiluong) {
        this.tenbaihat = tenbaihat;
        this.tacgia = tacgia;
        this.baihaturl = baihaturl;
        this.hinhanh = hinhanh;
        this.thoiluong = thoiluong;
    }

    public String getTenbaihat() {
        return tenbaihat;
    }

    public void setTenbaihat(String tenbaihat) {
        this.tenbaihat = tenbaihat;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public String getBaihaturl() {
        return baihaturl;
    }

    public void setBaihaturl(String baihaturl) {
        this.baihaturl = baihaturl;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getThoiluong() {
        return thoiluong;
    }

    public void setThoiluong(String thoiluong) {
        this.thoiluong = thoiluong;
    }
}
