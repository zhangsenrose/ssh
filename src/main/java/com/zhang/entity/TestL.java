package com.zhang.entity;

/**
 * Create By ZhangSenWei on 2018/7/12
 **/
public class TestL {

    private Integer id;
    private  String name;
    private String carId;
    private String carNum;


    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestL{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", carId='" + carId + '\'' +
                ", carNum='" + carNum + '\'' +
                '}';
    }
}
