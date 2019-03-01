package com.surya;

import java.util.ArrayList;

public class Booking {
    private int customerId;
    private char pickupPoint;
    private char dropPoint;
    private int pickupTime;
    private int dropTime;
    private int billAmount;

    public Booking(int customerId, char pickupPoint, char dropPoint, int pickupTime) {
        this.customerId = customerId;
        this.pickupPoint = pickupPoint;
        this.dropPoint = dropPoint;
        this.pickupTime = pickupTime;
    }

    public void droptime() {
        this.dropTime = pickupTime + Math.abs(dropPoint - pickupPoint);

    }

    public void calculate_Bill() {
        int distance = Math.abs(pickupPoint - dropPoint) * 15;
        this.billAmount = ((distance - 5) * 10) + 100;

    }

    public Taxi is_available(ArrayList<Taxi> taxi) {
        int min = 6;
        Taxi allocatedTaxi = null;
        for (Taxi taxi_cars : taxi) {

            if (Math.abs(this.pickupPoint - taxi_cars.getInitialPoint()) <= min && taxi_cars.getAvailabilityTime() < this.pickupTime)
            {
                if (Math.abs(this.pickupPoint - taxi_cars.getInitialPoint()) < min)
                    allocatedTaxi = taxi_cars;

                if (Math.abs(this.pickupPoint - taxi_cars.getInitialPoint()) == min && taxi_cars.getEarnings() != 0) {
                    if (allocatedTaxi.getEarnings() > taxi_cars.getEarnings()) {
                        allocatedTaxi = taxi_cars;

                    }

                }
                min = Math.abs(this.pickupPoint - taxi_cars.getInitialPoint());
            }
        }
        allocatedTaxi.setAvailabilityTime(this.pickupTime, this.pickupPoint, this.dropPoint);
        allocatedTaxi.setInitialPoint(this.dropPoint);

        return allocatedTaxi;

    }

    public char getPickupPoint() {
        return pickupPoint;
    }

    public char getDropPoint() {
        return dropPoint;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getPickupTime() {
        return pickupTime;
    }

    public int getDropTime() {
        return dropTime;
    }

    public int getBillAmount() {
        return billAmount;
    }
}
