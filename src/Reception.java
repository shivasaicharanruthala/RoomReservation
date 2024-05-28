import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Reception implements IReception {
    private static Reception instance;
    private List<Room> rooms;
    private BookingDAO bookingDAO;

    private Reception() {
        rooms = new ArrayList<>();
        bookingDAO = new BookingDAO();
    }

    private static class ReceptionHelper {
        private static final Reception reception = new Reception();
    }

    public static Reception getInstance() {
//        if (instance == null) {
//            instance = new Reception();
//        }
//        return instance;
        return ReceptionHelper.reception;
    }

    @Override
    public void addRoom(Room room) {
        rooms.add(room);
    }

    @Override
    public List<Room> checkAvailability(int numberOfPeople, Date date) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getCapacity() >= numberOfPeople && room.isAvailable() &&
                    !bookingDAO.isBooked(room.getRoomNumber(), date)) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    @Override
    public void displayAmenities(String roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber().equals(roomNumber)) {
                System.out.println("Amenities for Room " + roomNumber + ": " + room.getAmenities());
                return;
            }
        }
        System.out.println("Room not found.");
    }

    @Override
    public void bookRoom(String roomNumber, Date date) {
        if (!bookingDAO.isBooked(roomNumber, date)) {
            bookingDAO.saveBooking(roomNumber, date);
            System.out.println("Room " + roomNumber + " booked for " + date);
        } else {
            System.out.println("Room " + roomNumber + " is already booked for " + date);
        }
    }

    @Override
    public void checkOutRoom(String roomNumber, Date date) {
        if (bookingDAO.isBooked(roomNumber, date)) {
            bookingDAO.removeBooking(roomNumber, date);
            System.out.println("Room " + roomNumber + " checked out for " + date);
        } else {
            System.out.println("Room " + roomNumber + " was not booked for " + date);
        }
    }
}
