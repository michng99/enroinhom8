package com.freesongs.musikplayer8.Model;

public class Songs {

    private String hinhanh;
    private String tenbaihat;
    private String file;
    private String tentacgia;
    private Integer luotnghe;
    private String theloai;

    public Songs(String hinhanh, String tenbaihat, String file, String tentacgia, Integer luotnghe, String theloai) {
        this.hinhanh = hinhanh;
        this.tenbaihat = tenbaihat;
        this.file = file;
        this.tentacgia = tentacgia;
        this.luotnghe = luotnghe;
        this.theloai = theloai;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getTenbaihat() {
        return tenbaihat;
    }

    public void setTenbaihat(String tenbaihat) {
        this.tenbaihat = tenbaihat;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getTentacgia() {
        return tentacgia;
    }

    public void setTentacgia(String tentacgia) {
        this.tentacgia = tentacgia;
    }

    public Integer getLuotnghe() {
        return luotnghe;
    }

    public void setLuotnghe(Integer luotnghe) {
        this.luotnghe = luotnghe;
    }

    public String getTheloai() {
        return theloai;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }
}
