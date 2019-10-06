package ua.training.util.constans;

public enum  UserTypes {
    INDIVIDUAL("individual"), LEGAL_ENTITY("legal entity"), INSPECTOR("inspector"), ADMIN("admin");
    String type;

    UserTypes(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
