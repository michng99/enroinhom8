package com.freesongs.musikplayer8.Model;

public class Songs {

    private String tenbaihat;
    private String file;

    public Songs(String tenbaihat, String file) {
        this.tenbaihat = tenbaihat;
        this.file = file;
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
}
