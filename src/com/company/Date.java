package com.company;

public class Date { //класс хронящий поля "месяц", "год" и их геттеры/сеттеры
    private int month, year;

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString(){
        return "Месяц: " + month + "\tГод: " + year;
    } //переопределение метода toString

    @Override  //переопределение метода equals
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Date other = (Date) obj;
        if (month != other.month)
            return false;
        if (year != other.year)
            return false;
        return true;
    }
}
