import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

class BookingDAO {
    private static final String FILE_NAME = "bookings.csv";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public BookingDAO() {
        // Create the file if it doesn't exist
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveBooking(String roomNumber, Date date) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(roomNumber + "," + dateFormat.format(date));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String[]> getAllBookings() {
        List<String[]> bookings = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                bookings.add(line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    public boolean isBooked(String roomNumber, Date date) {
        String formattedDate = dateFormat.format(date);
        for (String[] booking : getAllBookings()) {
            if (booking[0].equals(roomNumber) && booking[1].equals(formattedDate)) {
                return true;
            }
        }
        return false;
    }

    public void removeBooking(String roomNumber, Date date) {
        List<String[]> bookings = getAllBookings();
        String formattedDate = dateFormat.format(date);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String[] booking : bookings) {
                if (!(booking[0].equals(roomNumber) && booking[1].equals(formattedDate))) {
                    writer.write(booking[0] + "," + booking[1]);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
