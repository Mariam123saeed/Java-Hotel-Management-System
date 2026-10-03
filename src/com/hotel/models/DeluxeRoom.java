package com.hotel.models;

import com.hotel.services.Service;

import java.util.ArrayList;

public class DeluxeRoom extends Room{

    public DeluxeRoom(String roomNumber, double baseRate, ArrayList<Service> services, boolean isBooked, Customer customer) {
        super(roomNumber, baseRate, services, isBooked, customer);
    }

    @Override
    public String getDescription()
    {
        return "DeluxeRoom";
    }
}
