package com.example.studyroom.Model;

/**
 * Created by hong on 2018-05-18.
 */

public class UserModel {

    String email;
    String phoneNumber;
    String userKey;
    CardModel cardModel;


    public UserModel(String email, String phoneNumber, CardModel cardModel, String userKey) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.cardModel = cardModel;
        this.userKey = userKey;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public CardModel getCardModel() {
        return cardModel;
    }

    public void setCardModel(CardModel cardModel) {
        this.cardModel = cardModel;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }
}
