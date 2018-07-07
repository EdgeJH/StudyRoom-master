package com.example.studyroom.Model;

/**
 * Created by hong on 2018-05-18.
 */

public class UserModel {

    String email;
    String phoneNumber;
    CardModel cardModel;
    ReserveModel reservModel;

    public UserModel(String email, String phoneNumber, CardModel cardModel, ReserveModel reservModel) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.cardModel = cardModel;
        this.reservModel = reservModel;
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

    public ReserveModel getReservModel() {
        return reservModel;
    }

    public void setReservModel(ReserveModel reservModel) {
        this.reservModel = reservModel;
    }
}
