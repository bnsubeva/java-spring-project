package bg.springboot5.taskmanagementsystem.enums;

public enum Priority {
    LOW("LOW"),
    HIGH("HIGH"),
    MEDIUM("MEDIUM");


    private final String name;

     Priority(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
