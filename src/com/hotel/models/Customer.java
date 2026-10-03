package com.hotel.models;

public class Customer {
    private String name,email,phonNumber;

    public Customer(String name, String email, String phonNumber) {
        setName(name);
        setEmail(email);
        setPhonNumber(phonNumber);
    }
   //Validation Methods
    boolean canBeEmpty(String value) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        return true;
    }

    boolean emailFormat(String email) {
        if(email.contains("@"))
        {
            return true;
        }
        return false;
    }
    public String getName() {
        return name;
    }

    //Setters&Getters
    public void setName(String name) {
        if(canBeEmpty(name))
        {
            this.name = name;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(emailFormat(email))
        {
            this.email = email;
        }

    }

    public String getPhonNumber() {
        return phonNumber;
    }

    public void setPhonNumber(String phonNumber) {
        if(canBeEmpty(phonNumber))
        {
            this.phonNumber = phonNumber;
        }

    }

    @Override
    public String toString() {
        return name + " (" + email + ", " + phonNumber + ")";
    }



}
