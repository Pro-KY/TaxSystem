package ua.training.util.constans;

public enum StateApprovalEnum {
    APPROVED(1L), CANCELED(2L), REQUIRE_CHANGES(3L), PROCESSING(4L), CHANGED(5L);
    Long stateId;

    StateApprovalEnum(Long stateId) {
        this.stateId = stateId;
    }

    public Long getStateId() {
        return stateId;
    }
}
