import java.util.*;

abstract class Room {
    private String roomNumber;
    private int capacity;
    private boolean isAvailable;
    private Map<String, Boolean> amenities;

    protected Room(RoomBuilder builder) {
        this.roomNumber = builder.roomNumber;
        this.capacity = builder.capacity;
        this.isAvailable = builder.isAvailable;
        this.amenities = builder.amenities;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Map<String, Boolean> getAmenities() {
        return amenities;
    }

    public static abstract class RoomBuilder<T extends RoomBuilder<T>> {
        private String roomNumber;
        private int capacity;
        private boolean isAvailable;
        private Map<String, Boolean> amenities = new HashMap<>();

        public T roomNumber(String roomNumber) {
            this.roomNumber = roomNumber;
            return self();
        }

        public T capacity(int capacity) {
            this.capacity = capacity;
            return self();
        }

        public T isAvailable(boolean isAvailable) {
            this.isAvailable = isAvailable;
            return self();
        }

        public T addAmenity(String amenity, boolean available) {
            this.amenities.put(amenity, available);
            return self();
        }

        protected abstract T self();

        public abstract Room build();
    }
}






