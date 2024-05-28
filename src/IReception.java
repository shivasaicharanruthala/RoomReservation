import java.util.Date;
import java.util.List;

interface IReception {
    void addRoom(Room room);
    List<Room> checkAvailability(int numberOfPeople, Date date);
    void displayAmenities(String roomNumber);
    void bookRoom(String roomNumber, Date date);
    void checkOutRoom(String roomNumber, Date date);
}