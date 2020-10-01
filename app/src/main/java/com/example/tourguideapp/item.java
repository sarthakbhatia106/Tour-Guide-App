package com.example.tourguideapp;

public class item {

    private String name;
    private String add;
    private String coor;

    public item(String name, String add,String coor){
        this.name= name;
        this.add= add;
        this.coor=coor;
    }

    public String getName(){
        return name;
    }
    public String getAdd(){
        return add;
    }
    public String getCoor(){return coor;}
}
