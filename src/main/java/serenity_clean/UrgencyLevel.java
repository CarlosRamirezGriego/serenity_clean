package serenity_clean;

public enum UrgencyLevel {
    URGENT ("Urgent"), NORMAL ("Normal"), LOW ("Low");

    private final String label;

    UrgencyLevel(String label) {
        this.label = label;
    }

}
