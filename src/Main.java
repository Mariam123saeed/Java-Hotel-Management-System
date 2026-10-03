import com.hotel.management.Hotel;
import com.hotel.models.Customer;
import com.hotel.models.DeluxeRoom;
import com.hotel.models.Room;
import com.hotel.models.StandardRoom;
import com.hotel.models.SuiteRoom;
import com.hotel.services.DiningService;
import com.hotel.services.GymService;
import com.hotel.services.SpaService;
import com.hotel.management.Hotel;

import java.util.ArrayList;
import java.util.HashMap;



 void main(){

        Hotel hotel = new Hotel(new HashMap<>(), "Grand Hotel");

        Room room101 = new StandardRoom("101", 200, new ArrayList<>(), false, null);
        Room room102 = new DeluxeRoom("102", 300, new ArrayList<>(), false, null);
        Room room103 = new SuiteRoom("103", 500, new ArrayList<>(), false, null);
        Room room104 = new StandardRoom("104", 200, new ArrayList<>(), false, null);

        hotel.addRoom(room101);
        hotel.addRoom(room102);
        hotel.addRoom(room103);
        hotel.addRoom(room104);


        Customer jane = new Customer("Jane Smith", "jane@email.com", "555-0101");
        Customer john = new Customer("John Smith", "john@email.com", "555-0102");
        Customer sara = new Customer("Sara Ali", "sara@email.com", "555-0103");



        hotel.bookRoom("101", jane, new DiningService());
        hotel.bookRoom("102", john, new SpaService(), new DiningService());

        hotel.bookRoom("103", sara, new SpaService(), new GymService());


        System.out.println("\n===== BOOKING DETAILS =====");
        hotel.displayBookingDetails("101");
        System.out.println();
        hotel.displayBookingDetails("102");
        System.out.println();
        hotel.displayBookingDetails("103");


        System.out.println("\n===== RE-BOOKING TEST =====");

        hotel.bookRoom(
                "101",
                sara,
                new SpaService()
        );

        System.out.println("\n===== ALL ROOMS =====");
        hotel.displayAllRooms();


        System.out.println("\n===== AVAILABLE ROOMS =====");
        ArrayList<Room> availableRooms = hotel.getAvailableRooms();
        for (Room room : availableRooms) {
            System.out.println(room.getRoomNumber() + " - " + room.getDescription());
        }
    }
