package s24260.demo;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EventService {
    EventStorage eventStorage;

    public EventService(EventStorage eventStorage) {
        this.eventStorage = eventStorage;
    }

    public Event addEvent(UUID uuid, EventType status, String title, String description, EventReporter eventReporter, Employee employee) {
        return this.eventStorage.addNewEvent(uuid,status, title, description, eventReporter, employee);
    }

    public void changeEventType(Event event, EventType type) {
        Event checkedEvent = this.eventStorage.getEventByUuid(event.uuid);

        if (checkedEvent != null) {
            checkedEvent.setType(type);
        }
    }

    public void changeEventReporter(Event event, EventReporter eventReporter) {
        Event checkedEvent = this.eventStorage.getEventByUuid(event.uuid);

        if (checkedEvent != null) {
            checkedEvent.setEventReporter(eventReporter);
        }
    }

    public Event getEventByUuid(UUID uuid) {
        return this.eventStorage.getEventByUuid(uuid);
    }
}
