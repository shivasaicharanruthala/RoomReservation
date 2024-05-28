class SuiteRoom extends Room {
    private SuiteRoom(SuiteRoomBuilder builder) {
        super(builder);
    }

    public static class SuiteRoomBuilder extends RoomBuilder<SuiteRoomBuilder> {
        @Override
        protected SuiteRoomBuilder self() {
            return this;
        }

        @Override
        public Room build() {
            return new SuiteRoom(this);
        }
    }
}