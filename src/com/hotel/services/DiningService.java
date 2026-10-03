package com.hotel.services;

public class DiningService implements Service{

    @Override
    public double getCost()
    {
        return 150;
    }
    @Override
    public String getName()
    {
        return "DiningService";
    }
}
