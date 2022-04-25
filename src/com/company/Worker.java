package com.company;

public class Worker {
    private LFP workerLFP = new LFP();
    private Address workerAddress = new Address();
    private Date dateOfEmployment = new Date();

    public LFP getWorkerLFP() {
        return workerLFP;
    }

    public Address getWorkerAddress() {
        return workerAddress;
    }

    public Date getDateOfEmployment() {
        return dateOfEmployment;
    }

    public Worker(String lastName, String firstName, String patronymic, String street, int house, int apartment, int month, int year){
        workerLFP.setLastName(lastName);
        workerLFP.setFirstName(firstName);
        workerLFP.setPatronymic(patronymic);

        workerAddress.setStreet(street);
        workerAddress.setHouse(house);
        workerAddress.setApartment(apartment);

        dateOfEmployment.setMonth(month);
        dateOfEmployment.setYear(year);
    }


    @Override //переопределение метода toString
    public String toString(){
        return workerLFP + "\n" + workerAddress + "\n" + dateOfEmployment;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Worker other = (Worker) obj;
        if (workerLFP != other.workerLFP)
            return false;
        if (workerAddress != other.workerAddress)
            return false;
        if (dateOfEmployment != other.dateOfEmployment)
            return false;
        return true;
    }
}
