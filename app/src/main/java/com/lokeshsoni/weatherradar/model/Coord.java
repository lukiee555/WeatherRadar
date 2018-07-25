package com.lokeshsoni.weatherradar.model;

public class Coord {

    public double lon ;
    public double lat ;

    public Coord(double lon, double lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public Coord() {
    }

    @Override
    public String toString(){
        return new StringBuilder("[").append(this.lat).append(",").append(this.lon).append("]").toString();
    }


}
