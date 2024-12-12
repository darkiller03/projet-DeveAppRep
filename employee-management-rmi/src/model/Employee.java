package model;

import java.io.Serializable;

public class Employee implements Serializable {
    private String name;
    private String surname;
    private String email;
    private String cin;
    private String address;
    private String phone;

    public Employee(String name, String surname, String email, String cin, String address, String phone) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.cin = cin;
        this.address = address;
        this.phone = phone;
    }

    // Getters et Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Employee Details:\n" +
                    "Name: " + name + "\n" +
                    "Surname: " + surname + "\n" +
                    "Email: " + email + "\n" +
                    "CIN: " + cin + "\n" +
                    "Address: " + address + "\n" +
                    "Phone: " + phone;
    }

}
