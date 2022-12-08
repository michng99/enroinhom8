package com.freesongs.musikplayer8.model;

import android.net.Uri;

public class Playlists {

    private String imgPath;
    private String tenPlaylist;
    private String demBaiHat;

    public Playlists(String imgPath) {
        this.imgPath = imgPath;
        this.tenPlaylist = tenPlaylist;
        this.demBaiHat = demBaiHat;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getTenPlaylist() {
        return tenPlaylist;
    }

    public void setTenPlaylist(String tenPlaylist) {
        this.tenPlaylist = tenPlaylist;
    }

    public String getDemBaiHat() {
        return demBaiHat;
    }

    public void setDemBaiHat(String demBaiHat) {
        this.demBaiHat = demBaiHat;
    }
}
