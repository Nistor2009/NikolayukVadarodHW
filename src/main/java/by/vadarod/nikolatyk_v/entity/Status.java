package by.vadarod.nikolatyk_v.entity;

public enum Status {
    ACTIVE("ACTIVE"),
    BLOCKED("BLOCKED"),
    PRIME("PRIME");

    private final String title;

    Status(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
