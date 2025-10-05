package by.vadarod.nikolatyk_v.entity;

public enum ClientStatus {
    ACTIVE("ACTIVE"),
    BLOCKED("BLOCKED"),
    PRIME("PRIME");

    private final String title;

    ClientStatus(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
