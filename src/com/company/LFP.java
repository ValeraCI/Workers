package com.company;

public class LFP { //класс хронящий поля "фамилия", "имя", "отчество" и их геттеры/сеттеры
    private String lastName, firstName, patronymic;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Override
    public String toString(){ //переопределение метода toString
        return "Фамилия: " + lastName + "\tИмя: " + firstName + "\tОтчество: " + patronymic;
    }

    @Override  //переопределение метода equals
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LFP other = (LFP) obj;
        if (!lastName.equals(other.lastName))
            return false;
        if (!firstName.equals(other.firstName))
            return false;
        if (!patronymic.equals(other.patronymic))
            return false;
        return true;
    }
}
