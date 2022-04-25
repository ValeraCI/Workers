package com.company;

public class Address { //класс хронящий поля "улица", "дом", "квартира" и их геттеры/сеттеры
    private String street;
    private int house, apartment;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString(){
        return "Улица: " + street + "\tДом: " + house+ "\tКвартира: " + house;
    } //переопределение метода toString


    @Override  //переопределение метода equals
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Address other = (Address) obj;
        if (!street.equals(other.street))
            return false;
        if (house != other.house)
            return false;
        if (apartment != other.apartment)
            return false;
        return true;
    }
}
