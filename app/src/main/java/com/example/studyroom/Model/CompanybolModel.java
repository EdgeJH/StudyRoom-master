package com.example.studyroom.Model;

/**
 * Created by hong on 2018-05-14.
 */

public class CompanybolModel {

    boolean wifi;
    boolean PC;
    boolean water;
    boolean printMachine;
    boolean beamProject;
    boolean lounge;
    boolean parkingLot;
    boolean TV;
    boolean whiteBoard;

    public CompanybolModel(boolean wifi, boolean PC, boolean water, boolean printMachine, boolean beamProject,
                           boolean lounge, boolean parkingLot, boolean TV, boolean whiteBoard) {
        this.wifi = wifi;
        this.PC = PC;
        this.water = water;
        this.printMachine = printMachine;
        this.beamProject = beamProject;
        this.lounge = lounge;
        this.parkingLot = parkingLot;
        this.TV = TV;
        this.whiteBoard = whiteBoard;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isPC() {
        return PC;
    }

    public void setPC(boolean PC) {
        this.PC = PC;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isPrintMachine() {
        return printMachine;
    }

    public void setPrintMachine(boolean printMachine) {
        this.printMachine = printMachine;
    }

    public boolean isBeamProject() {
        return beamProject;
    }

    public void setBeamProject(boolean beamProject) {
        this.beamProject = beamProject;
    }

    public boolean isLounge() {
        return lounge;
    }

    public void setLounge(boolean lounge) {
        this.lounge = lounge;
    }

    public boolean isParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(boolean parkingLot) {
        this.parkingLot = parkingLot;
    }

    public boolean isTV() {
        return TV;
    }

    public void setTV(boolean TV) {
        this.TV = TV;
    }

    public boolean isWhiteBoard() {
        return whiteBoard;
    }

    public void setWhiteBoard(boolean whiteBoard) {
        this.whiteBoard = whiteBoard;
    }
}
