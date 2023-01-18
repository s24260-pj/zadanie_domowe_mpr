package s24260.demo;

import java.util.UUID;

public class Event {
    UUID uuid;
    private EventType type;
    private String title;
    private String description;
    private EventReporter eventReporter;
    private Employee employee;

    public Event(UUID uuid, EventType type, String title, String description, EventReporter eventReporter, Employee employee) {
        this.uuid = uuid == null
                ? UUID.randomUUID()
                : uuid;
        this.type = type;
        this.title = title;
        this.description = description;
        this.eventReporter = eventReporter;
        this.employee = employee;
    }
    public UUID getUuid() {
        return uuid;
    }
    public void setType(EventType type) {
        this.type = type;
    }

    public EventType getType() {
        return type;
    }

    public void setEventReporter(EventReporter eventReporter) {
        this.eventReporter = eventReporter;
    }

    public EventReporter getEventReporter() {
        return this.eventReporter;
    }

    @Override
    public String toString() {
        return "Event{" +
                "uuid=" + uuid +
                ", type=" + type +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", eventReporter=" + eventReporter +
                ", employee=" + employee +
                '}';
    }
}