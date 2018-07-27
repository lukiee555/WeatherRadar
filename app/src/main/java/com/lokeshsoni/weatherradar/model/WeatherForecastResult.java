package com.lokeshsoni.weatherradar.model;

import java.util.ArrayList;

public class WeatherForecastResult {

    public String cod;
    public double message;
    public int cnt;
    public ArrayList<MyList> list;
    public City city;



    public WeatherForecastResult() {
    }

    public WeatherForecastResult(String cod, double message, int cnt, ArrayList<MyList> list, City city) {
        this.cod = cod;
        this.message = message;
        this.cnt = cnt;
        this.list = list;
        this.city = city;
    }

    public String getCod() { return this.cod; }

    public void setCod(String cod) { this.cod = cod; }

    public double getMessage() { return this.message; }

    public void setMessage(double message) { this.message = message; }

    public int getCnt() { return this.cnt; }

    public void setCnt(int cnt) { this.cnt = cnt; }

    public ArrayList<MyList> getList() { return this.list; }

    public void setList(ArrayList<MyList> list) { this.list = list; }

    public City getCity() { return this.city; }

    public void setCity(City city) { this.city = city; }

}
