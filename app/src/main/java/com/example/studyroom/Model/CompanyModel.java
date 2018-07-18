package com.example.studyroom.Model;

import java.io.Serializable;

/**
 * Created by hong on 2018-05-11.
 */

public class CompanyModel implements Serializable{

    //업체에서 고객에게 넘겨줄 데이터
    private String operatingTime;
    private String companyName;
    private String companyKey;
    private int roomImage;
    private int possibleNum;
    private int price;
    private CompanybolModel companybolModel;

    private float latitude;
    private float longitude;

    public CompanyModel() {
    }

    private CompanyModel(Builder builder) {
        this.operatingTime = builder.operatingTime;
        this.companyName = builder.companyName;
        this.roomImage = builder.roomImage;
        this.possibleNum = builder.possibleNum;
        this.price = builder.price;
        this.companybolModel = builder.companybolModel;
        this.latitude = builder.latitude;
        this.longitude = builder.longitude;
        this.companyKey = builder.companyKey;
    }

    public static class Builder {
        String operatingTime;
        String companyName;
        String companyKey;
        int roomImage;
        int possibleNum;
        int price;
        CompanybolModel companybolModel;
        float latitude;
        float longitude;

        public Builder setCompanyKey(String companyKey) {
            this.companyKey = companyKey;
            return this;
        }

        public Builder setOperatingTime(String operatingTime) {
            this.operatingTime = operatingTime;
            return this;
        }

        public Builder setCompanyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Builder setRoomImage(int roomImage) {
            this.roomImage = roomImage;
            return this;
        }

        public Builder setPossibleNum(int possibleNum) {
            this.possibleNum = possibleNum;
            return this;
        }

        public Builder setPrice(int price) {
            this.price = price;
            return this;
        }

        public Builder setCompanybolModel(CompanybolModel companybolModel) {
            this.companybolModel = companybolModel;
            return this;
        }

        public Builder setLatitude(float latitude) {
            this.latitude = latitude;
            return this;
        }

        public Builder setLongitude(float longitude) {
            this.longitude = longitude;
            return this;
        }

        public CompanyModel build() {
            return new CompanyModel(this);
        }
    }

    public String getOperatingTime() {
        return operatingTime;
    }

    public void setOperatingTime(String operatingTime) {
        this.operatingTime = operatingTime;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getRoomImage() {
        return roomImage;
    }

    public void setRoomImage(int roomImage) {
        this.roomImage = roomImage;
    }

    public int getPossibleNum() {
        return possibleNum;
    }

    public void setPossibleNum(int possibleNum) {
        this.possibleNum = possibleNum;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }


    public String getCompanyKey() {
        return companyKey;
    }

    public void setCompanyKey(String companyKey) {
        this.companyKey = companyKey;
    }

    public CompanybolModel getCompanybolModel() {
        return companybolModel;
    }

    public void setCompanybolModel(CompanybolModel companybolModel) {
        this.companybolModel = companybolModel;
    }

}
