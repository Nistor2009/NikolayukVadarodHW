package by.vadarod.nikolatyk_v.entity;

public enum BuildingStatus {
    ACTIVE("ACTIVE"),
    REPAIR("REPAIR");

    private final String title;

    BuildingStatus(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
