package com.example.studyroom.Model;

/**
 * Created by hong on 2018-05-11.
 */

public class ReserveModel {

    String phoneNumber;
    String userName;
    String roomInfo;
    int startTime;
    int endTime;
    int numOfpeople;

    public ReserveModel(String phoneNumber, String userName, String roomInfo, int startTime, int endTime, int numOfpeople) {
        this.phoneNumber = phoneNumber;
        this.userName = userName;
        this.roomInfo = roomInfo;
        this.startTime = startTime;
        this.endTime = endTime;
        this.numOfpeople = numOfpeople;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoomInfo() {
        return roomInfo;
    }

    public void setRoomInfo(String roomInfo) {
        this.roomInfo = roomInfo;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getNumOfpeople() {
        return numOfpeople;
    }

    public void setNumOfpeople(int numOfpeople) {
        this.numOfpeople = numOfpeople;
    }
}
