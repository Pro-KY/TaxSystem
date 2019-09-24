package ua.training.util.constans;

public enum ReportContentType {
    FORM(1),JSON(2), XML(3);
    int stateId;

    ReportContentType(int stateId) {
        this.stateId = stateId;
    }

    public int getId() {
        return stateId;
    }
}
