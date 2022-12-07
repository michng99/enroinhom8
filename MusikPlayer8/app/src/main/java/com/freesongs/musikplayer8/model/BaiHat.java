package com.freesongs.musikplayer8.model;

public class BaiHat {

    private String tenbaihat, tacgia, baihat, hinhanh, thoiluong;

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
