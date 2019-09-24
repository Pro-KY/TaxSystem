package ua.training.util.constans;

public enum ReportStateEnum {
    APPROVED(1), CANCELED(2), REQUIRE_CHANGES(3), PROCESSING(4);
    long stateId;

    ReportStateEnum(long stateId) {
        this.stateId = stateId;
    }

    public long getStateId() {
        return stateId;
    }
}
