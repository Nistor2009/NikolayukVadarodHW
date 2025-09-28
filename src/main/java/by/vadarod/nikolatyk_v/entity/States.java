package by.vadarod.nikolatyk_v.entity;

public enum States {
    ACTIVE("ACTIVE"),
    BLOCKED("BLOCKED"),
    PRIME("PRIME");

    private final String title;

    States(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
