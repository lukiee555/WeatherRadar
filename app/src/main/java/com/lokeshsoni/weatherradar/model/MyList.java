package com.lokeshsoni.weatherradar.model;

import java.util.ArrayList;

public class MyList {

    public int dt;
    public Main main;
    public ArrayList<Weather> weather;
    public Clouds clouds;
    public Wind wind;
    public Rain rain;
    public Sys sys;
    public String dt_txt;

    public MyList() {
    }

    public MyList(int dt, Main main, ArrayList<Weather> weather, Clouds clouds, Wind wind, Rain rain, Sys sys, String dt_txt) {
        this.dt = dt;
        this.main = main;
        this.weather = weather;
        this.clouds = clouds;
        this.wind = wind;
        this.rain = rain;
        this.sys = sys;
        this.dt_txt = dt_txt;
    }


    public int getDt() { return this.dt; }

    public void setDt(int dt) { this.dt = dt; }

    public Main getMain() { return this.main; }

    public void setMain(Main main) { this.main = main; }

    public ArrayList<Weather> getWeather() { return this.weather; }

    public void setWeather(ArrayList<Weather> weather) { this.weather = weather; }

    public Clouds getClouds() { return this.clouds; }

    public void setClouds(Clouds clouds) { this.clouds = clouds; }

    public Wind getWind() { return this.wind; }

    public void setWind(Wind wind) { this.wind = wind; }

    public Rain getRain() { return this.rain; }

    public void setRain(Rain rain) { this.rain = rain; }

    public Sys getSys() { return this.sys; }

    public void setSys(Sys sys) { this.sys = sys; }

    public String getDtTxt() { return this.dt_txt; }

    public void setDtTxt(String dt_txt) { this.dt_txt = dt_txt; }

}
