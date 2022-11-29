package com.freesongs.musikplayer8.model;

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
    @SerializedName("baihat")
    String baihat;

    @Expose
    @SerializedName("hinhanh")
    String hinhanh;

    @Expose
    @SerializedName("thoiluong")
    String thoiluong;




    public BaiHat(String tenbaihat, String tacgia, String baihat, String hinhanh, String thoiluong) {
        this.tenbaihat = tenbaihat;
        this.tacgia = tacgia;
        this.baihat = baihat;
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

    public String getBaihat() {
        return baihat;
    }

    public void setBaihat(String baihat) {
        this.baihat = baihat;
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

