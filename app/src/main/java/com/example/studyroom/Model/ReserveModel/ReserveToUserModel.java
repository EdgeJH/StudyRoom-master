package com.example.studyroom.Model.ReserveModel;

/**
 * Created by hong on 2018-05-11.
 */

public class ReserveToUserModel {

    private String startDate;
    private String endDate;
    private String startTime;
    private String endTime;
    private String companyPhoneNum;
    private String companyName;
    private String numberOfPeople;
    private int roomImage;

    public ReserveToUserModel() {
    }

    public ReserveToUserModel(Builder builder) {
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.companyPhoneNum = builder.companyPhoneNum;
        this.companyName = builder.companyName;
        this.numberOfPeople = builder.numberOfPeople;
        this.roomImage = builder.roomImage;
    }

    public static class Builder {
        String startDate;
        String endDate;
        String startTime;
        String endTime;
        String companyPhoneNum;
        String companyName;
        String numberOfPeople;
        int roomImage;


        public Builder setStartDate(String startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder setEndDate(String endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder setStartTime(String startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder setEndTime(String endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder setCompanyPhoneNum(String companyPhoneNum) {
            this.companyPhoneNum = companyPhoneNum;
            return this;
        }

        public Builder setCompanyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Builder setNumberOfPeople(String numberOfPeople) {
            this.numberOfPeople = numberOfPeople;
            return this;
        }

        public Builder setRoomImage(int roomImage) {
            this.roomImage = roomImage;
            return this;
        }
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCompanyPhoneNum() {
        return companyPhoneNum;
    }

    public void setCompanyPhoneNum(String companyPhoneNum) {
        this.companyPhoneNum = companyPhoneNum;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(String numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public int getRoomImage() {
        return roomImage;
    }

    public void setRoomImage(int roomImage) {
        this.roomImage = roomImage;
    }
}
