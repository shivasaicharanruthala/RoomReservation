class StandardRoom extends Room {
    private StandardRoom(StandardRoomBuilder builder) {
        super(builder);
    }

    public static class StandardRoomBuilder extends RoomBuilder<StandardRoomBuilder> {
        @Override
        protected StandardRoomBuilder self() {
            return this;
        }

        @Override
        public Room build() {
            return new StandardRoom(this);
        }
    }
}