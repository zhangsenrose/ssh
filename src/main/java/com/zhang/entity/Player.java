package com.zhang.entity;

public class Player {
    private Integer pId;

    private String pName;

    private String pAge;

    private String pCountry;

    private String pTeam;

    private String pIntroduce;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public String getpAge() {
        return pAge;
    }

    public void setpAge(String pAge) {
        this.pAge = pAge == null ? null : pAge.trim();
    }

    public String getpCountry() {
        return pCountry;
    }

    public void setpCountry(String pCountry) {
        this.pCountry = pCountry == null ? null : pCountry.trim();
    }

    public String getpTeam() {
        return pTeam;
    }

    public void setpTeam(String pTeam) {
        this.pTeam = pTeam == null ? null : pTeam.trim();
    }

    public String getpIntroduce() {
        return pIntroduce;
    }

    public void setpIntroduce(String pIntroduce) {
        this.pIntroduce = pIntroduce == null ? null : pIntroduce.trim();
    }
}