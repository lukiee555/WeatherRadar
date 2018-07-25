package com.lokeshsoni.weatherradar.model;

public class Wind {

    private double speed;

    public double getSpeed() { return this.speed; }

    public void setSpeed(double speed) { this.speed = speed; }

    private int deg;

    public int getDeg() { return this.deg; }

    public void setDeg(int deg) { this.deg = deg; }

    public Wind() {
    }

    public Wind(double speed, int deg) {
        this.speed = speed;
        this.deg = deg;
    }

}
