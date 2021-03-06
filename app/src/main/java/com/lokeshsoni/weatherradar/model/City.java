package com.lokeshsoni.weatherradar.model;

public class City {

    public int id;
    public String name;
    public Coord coord;
    public String country;


    public City() {
    }

    public City(int id, String name, Coord coord, String country) {
        this.id = id;
        this.name = name;
        this.coord = coord;
        this.country = country;
    }


    public int getId() { return this.id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return this.name; }

    public void setName(String name) { this.name = name; }

    public Coord getCoord() { return this.coord; }

    public void setCoord(Coord coord) { this.coord = coord; }

    public String getCountry() { return this.country; }

    public void setCountry(String country) { this.country = country; }

}
