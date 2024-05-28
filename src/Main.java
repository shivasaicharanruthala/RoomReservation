import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Reception reception = Reception.getInstance();

        Room room1 = RoomFactory.createRoom("Standard", "101", 2);
        Room room2 = RoomFactory.createRoom("Deluxe", "102", 3);
        Room room3 = RoomFactory.createRoom("Suite", "103", 4);

        reception.addRoom(room1);
        reception.addRoom(room2);
        reception.addRoom(room3);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = sdf.parse("27-05-2024");

        System.out.println("Available rooms for 3 people on " + date + ":");
        List<Room> availableRooms = reception.checkAvailability(3, date);
        for (Room room : availableRooms) {
            System.out.println("Room Number: " + room.getRoomNumber());
        }

        reception.displayAmenities("102");

        reception.bookRoom("102", date);
        reception.checkOutRoom("102", date);
    }
}
