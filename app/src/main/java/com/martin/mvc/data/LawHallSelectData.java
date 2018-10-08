package com.martin.mvc.data;

public class LawHallSelectData {

    private String city,name,money,number;
    private int people_image;

    public LawHallSelectData(String city, String name, String money, String number, int people_image) {
        this.city = city;
        this.name = name;
        this.money = money;
        this.number = number;
        this.people_image = people_image;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public String getMoney() {
        return money;
    }

    public String getNumber() {
        return number;
    }

    public int getPeople_image() {
        return people_image;
    }
}
