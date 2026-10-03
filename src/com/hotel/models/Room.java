package com.hotel.models;
import java.util.ArrayList;
import com.hotel.services.Service;


public abstract class Room {
    private String roomNumber;
    private double baseRate;
    private ArrayList<Service> services=new ArrayList<>();
    private boolean isBooked;
    private Customer customer;


    boolean canBeEmpty(String value) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        return true;
    }

    public Room(String roomNumber, double baseRate, ArrayList<Service> services, boolean isBooked, Customer customer) {
        setRoomNumber(roomNumber);
        setBaseRate(baseRate);
        setServices(services);
        setBooked(isBooked);
        setCustomer(customer);


    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        if(canBeEmpty(roomNumber))
        {
            this.roomNumber = roomNumber;
        }

    }

    public double getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(double baseRate) {
        if(baseRate>0)
        {
            this.baseRate = baseRate;
        }
        return;
    }

    public ArrayList<Service> getServices() {
        return services;
    }

    public void setServices(ArrayList<Service> services) {
        this.services = services;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }



   public abstract String getDescription();

    void addService(Service service)
    {
        if(isBooked())
        {
            services.add(service);
        }
        else{
            System.out.println("Cannot add service: room is not booked");
        }
    }

    public void addMultipleServices(Service... services){
       for(Service service : services)
       {
           addService(service);
       }
    }

    public double getTotalCost()
    {
        double total = baseRate;

        for (Service service : services) {
            total += service.getCost();
        }

        return total;
    }

    public void bookRoom(Customer customer){
        if (!isBooked()) {
            setCustomer(customer);
            setBooked(true);
        } else {
            System.out.println("Room is already booked");
        }
    }
    public void getBookingDetails(){
        System.out.println("Room : "+roomNumber+"- with base rate: "+baseRate+"-its services:"
                +services+"Booking status:"+isBooked+" (booked by: "+customer+")");
    }



}
