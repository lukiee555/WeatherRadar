package com.lokeshsoni.weatherradar.model;

public class Main {

    private double temp;

    public double getTemp() { return this.temp; }

    public void setTemp(double temp) { this.temp = temp; }

    private double pressure;

    public double getPressure() { return this.pressure; }

    public void setPressure(double pressure) { this.pressure = pressure; }

    private int humidity;

    public int getHumidity() { return this.humidity; }

    public void setHumidity(int humidity) { this.humidity = humidity; }

    private double temp_min;

    public double getTempMin() { return this.temp_min; }

    public void setTempMin(double temp_min) { this.temp_min = temp_min; }

    private double temp_max;

    public double getTempMax() { return this.temp_max; }

    public void setTempMax(double temp_max) { this.temp_max = temp_max; }

    private double sea_level;

    public double getSeaLevel() { return this.sea_level; }

    public void setSeaLevel(double sea_level) { this.sea_level = sea_level; }

    private double grnd_level;

    public double getGrndLevel() { return this.grnd_level; }

    public void setGrndLevel(double grnd_level) { this.grnd_level = grnd_level; }


    public Main() {
    }

    public Main(double temp, double pressure, int humidity, double temp_min, double temp_max, double sea_level, double grnd_level) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.sea_level = sea_level;
        this.grnd_level = grnd_level;
    }
}

