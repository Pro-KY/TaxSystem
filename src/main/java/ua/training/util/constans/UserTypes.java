package ua.training.util.constans;

public enum  UserTypes {
    INDIVIDUAL(1), LEGAL_ENTITY(2), INSPECTOR(3), ADMIN(4);
    int id;

    UserTypes(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
