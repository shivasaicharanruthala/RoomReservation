class DeluxeRoom extends Room {
    private DeluxeRoom(DeluxeRoomBuilder builder) {
        super(builder);
    }

    public static class DeluxeRoomBuilder extends RoomBuilder<DeluxeRoomBuilder> {
        @Override
        protected DeluxeRoomBuilder self() {
            return this;
        }

        @Override
        public Room build() {
            return new DeluxeRoom(this);
        }
    }
}