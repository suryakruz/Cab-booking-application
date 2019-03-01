package com.surya;

public class Taxi {
    private char initialPoint;
    private int availabilityTime;
    private double earnings;
    private int taxiNo;

    public Taxi(int number) {
        this.taxiNo=number;
        this.initialPoint='A';
        this.availabilityTime=0;
        this.earnings=0;
    }

    public void setInitialPoint(char initialPoint) {
        this.initialPoint = initialPoint;
    }

    public void setAvailabilityTime(int pickup, char pickpoint, char droppoint){
        availabilityTime=pickup+(Math.abs(pickpoint-droppoint));
    }

    public double totalEarning(char pickpoint,char droppoint){
        int distance=Math.abs(pickpoint-droppoint)*15;
        this.earnings+=((distance-5)*10)+100;
        return earnings;
    }

    public char getInitialPoint() {
        return initialPoint;
    }

    public int getAvailabilityTime() {
        return availabilityTime;
    }

    public double getEarnings() {
        return earnings;
    }

    public int getTaxiNo() {
        return taxiNo;
    }
}
