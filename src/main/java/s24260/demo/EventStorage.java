package s24260.demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class EventStorage {
    private List<Event> eventList;

    public EventStorage() {
        this.eventList = new ArrayList<>();
        Employee employee = new Employee("Tomek", "Nowak", 24);
        this.eventList.add(
                new Event(
                        UUID.randomUUID(),
                        EventType.NORMAL,
                        "Dodanie Nowego Użytkonika",
                        "Prosze dodać użytkownika, potrzebuje go do czegoś",
                        new EventReporter("Jan", "Kowalski", 12),
                        employee)
        );
        this.eventList.add(
                new Event(
                        UUID.randomUUID(),
                        EventType.URGENT,
                        "Dodanie 1",
                        "Prosze dodać użytkownika, potrzebuje go do czegoś",
                        new EventReporter("Jan", "Kowalski", 12),
                        employee)
        );
        this.eventList.add(
                new Event(
                        UUID.randomUUID(),
                        EventType.EASY,
                        "Dodanie 2",
                        "Prosze dodać użytkownika, potrzebuje go do czegoś",
                        new EventReporter("Jan", "Kowalski", 12),
                        employee)
        );
        this.eventList.add(
                new Event(
                        UUID.randomUUID(),
                        EventType.NORMAL,
                        "Dodanie 3",
                        "Prosze dodać użytkownika, potrzebuje go do czegoś",
                        new EventReporter("Jan", "Kowalski", 12),
                        employee)
        );
    }

    public Event getEventByUuid(UUID uuid) {
        return this.eventList
                .stream()
                .filter(event -> event.getUuid() == uuid)
                .findFirst()
                .get();
    }

    public Event addNewEvent(UUID uuid, EventType eventType, String title, String description, EventReporter eventReporter, Employee employee) {
        Event newEvent = new Event(uuid, eventType, title, description, eventReporter, employee);

        this.eventList.add(newEvent);

        return newEvent;
    }

    @Override
    public String toString() {
        return "EventStorage{" +
                "eventList=" + eventList +
                '}';
    }
}
