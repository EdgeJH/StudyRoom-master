package com.example.studyroom.Model;

/**
 * Created by hong on 2018-05-14.
 */

public class CardModel {
    String name;
    String cardNumber;
    String pwd;
    int month, year;

    public CardModel(String name, String cardNumber, String pwd, int month, int year) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.pwd = pwd;
        this.month = month;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
