
package com.freesongs.testcallapi.model;

import java.util.HashMap;
import java.util.Map;

public class BaiHat {

    private String id;

    private String tenbaihat;

    private String tacgia;

    private String baihat;

    private String hinhanh;

    private String thoiluong;

    private Integer v;

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public BaiHat() {
    }

    public BaiHat(String id, String tenbaihat, String tacgia, String baihat, String hinhanh, String thoiluong, Integer v) {
        super();
        this.id = id;
        this.tenbaihat = tenbaihat;
        this.tacgia = tacgia;
        this.baihat = baihat;
        this.hinhanh = hinhanh;
        this.thoiluong = thoiluong;
        this.v = v;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
