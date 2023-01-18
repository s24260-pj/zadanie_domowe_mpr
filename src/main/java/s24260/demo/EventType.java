package s24260.demo;

public enum EventType {
    URGENT("Urgent", 3),
    NORMAL("Normal", 2),
    EASY("Easy", 1);

    private final String type;
    private final int priority;

    EventType(String type, int priority) {
        this.type = type;
        this.priority = priority;
    }

    public String getType() {
        return type;
    }

    public int getPriority() {
        return priority;
    }
}