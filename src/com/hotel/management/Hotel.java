package com.hotel.management;
import com.hotel.models.Customer;
import com.hotel.models.Room;
import com.hotel.services.Service;

import java.util.ArrayList;
import java.util.HashMap;


public class Hotel {


    private HashMap<String, Room> rooms= new HashMap<>();
    private String hotelName;


    public Hotel(HashMap<String, Room> rooms, String hotelName) {
        setRooms(rooms);
        setHotelName(hotelName);
    }


    public void setRooms(HashMap<String, Room> rooms) {
        this.rooms = rooms;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    boolean duplicatedRoomNumber(String targetNumber) {
        return rooms.containsKey(targetNumber);
    }

    public void addRoom(Room room) {
        if (duplicatedRoomNumber(room.getRoomNumber())) {
            System.out.println("Room number already exists.");
            return;
        }
        rooms.put(room.getRoomNumber(), room);
    }

    public Room getRoom(String roomNumber) {
        return rooms.get(roomNumber);
    }

    public void bookRoom(String roomNumber, Customer customer, Service... services) {

        Room room = rooms.get(roomNumber);

        if (room == null) {
            System.out.println("Room not found.");
            return;
        }

        if (!room.isBooked()) {
            System.out.println("Room is already booked.");
            return;
        }

         room.bookRoom(customer);
         room.addMultipleServices(services);

        System.out.println("Room booked successfully.");
    }

    public void displayBookingDetails(String roomNumber)
    {
        Room room = rooms.get(roomNumber);
        if (room == null)
    {
        System.out.println("Room not found.");
        return;
    }
        room.getBookingDetails();
    }
    public void displayAllRooms()
    {
        for (Room room : rooms.values())
        { System.out.println(room.getDescription());
        }
    }

    public ArrayList<Room> getAvailableRooms()
    {
        ArrayList<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms.values())
        {
            if (!room.isBooked())
            {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }




}
