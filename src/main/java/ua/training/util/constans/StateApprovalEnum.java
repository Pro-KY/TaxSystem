package ua.training.util.constans;

public enum StateApprovalEnum {
    APPROVED(1), CANCELED(2), REQUIRE_CHANGES(3), PROCESSING(4), CHANGED(5);
    long stateId;

    StateApprovalEnum(long stateId) {
        this.stateId = stateId;
    }

    public long getStateId() {
        return stateId;
    }
}
