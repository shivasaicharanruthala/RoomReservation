class RoomFactory {
    public static Room createRoom(String type, String roomNumber, int capacity) {
        switch (type) {
            case "Standard":
                return new StandardRoom.StandardRoomBuilder()
                        .roomNumber(roomNumber)
                        .capacity(capacity)
                        .isAvailable(true)
                        .addAmenity("WiFi", true)
                        .addAmenity("TV", true)
                        .build();
            case "Deluxe":
                return new DeluxeRoom.DeluxeRoomBuilder()
                        .roomNumber(roomNumber)
                        .capacity(capacity)
                        .isAvailable(true)
                        .addAmenity("WiFi", true)
                        .addAmenity("TV", true)
                        .addAmenity("MiniBar", true)
                        .build();
            case "Suite":
                return new SuiteRoom.SuiteRoomBuilder()
                        .roomNumber(roomNumber)
                        .capacity(capacity)
                        .isAvailable(true)
                        .addAmenity("WiFi", true)
                        .addAmenity("TV", true)
                        .addAmenity("MiniBar", true)
                        .addAmenity("Jacuzzi", true)
                        .build();
            default:
                throw new IllegalArgumentException("Invalid room type");
        }
    }
}
