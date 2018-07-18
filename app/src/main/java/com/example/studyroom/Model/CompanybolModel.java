package com.example.studyroom.Model;

import java.io.Serializable;

/**
 * Created by hong on 2018-05-14.
 */

public class CompanybolModel implements Serializable {

    private boolean wifi;
    private boolean PC;
    private boolean water;
    private boolean printMachine;
    private boolean beamProject;
    private boolean lounge;
    private boolean parkingLot;
    private boolean whiteBoard;

    public CompanybolModel() {
    }

    public CompanybolModel(Builder builder) {
        this.wifi = builder.wifi;
        this.PC = builder.PC;
        this.water = builder.water;
        this.printMachine = builder.printMachine;
        this.beamProject = builder.beamProject;
        this.lounge = builder.lounge;
        this.parkingLot = builder.parkingLot;
        this.whiteBoard = builder.whiteBoard;
    }

    public static class Builder {
        boolean wifi;
        boolean PC;
        boolean water;
        boolean printMachine;
        boolean beamProject;
        boolean lounge;
        boolean parkingLot;
        boolean whiteBoard;

        public Builder setWifi(boolean wifi) {
            this.wifi = wifi;
            return this;
        }

        public Builder setPC(boolean PC) {
            this.PC = PC;
            return this;
        }

        public Builder setWater(boolean water) {
            this.water = water;
            return this;
        }

        public Builder setPrintMachine(boolean printMachine) {
            this.printMachine = printMachine;
            return this;
        }

        public Builder setBeamProject(boolean beamProject) {
            this.beamProject = beamProject;
            return this;
        }

        public Builder setLounge(boolean lounge) {
            this.lounge = lounge;
            return this;
        }

        public Builder setParkingLot(boolean parkingLot) {
            this.parkingLot = parkingLot;
            return this;
        }

        public Builder setWhiteBoard(boolean whiteBoard) {
            this.whiteBoard = whiteBoard;
            return this;
        }
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

    public boolean isWhiteBoard() {
        return whiteBoard;
    }

    public void setWhiteBoard(boolean whiteBoard) {
        this.whiteBoard = whiteBoard;
    }
}
