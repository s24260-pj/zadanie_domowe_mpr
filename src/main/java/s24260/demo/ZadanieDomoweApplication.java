package s24260.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class ZadanieDomoweApplication {
    EventStorage eventStorage;
    EventService eventService;

    public static void main(String[] args) {
        SpringApplication.run(ZadanieDomoweApplication.class, args);
    }

    public ZadanieDomoweApplication(EventService eventService, EventStorage eventStorage) {
        this.eventService = eventService;
        this.eventStorage = eventStorage;

        EventReporter eventReporter = new EventReporter("John", "Doe", 21);
        Employee employee = new Employee("Tom", "Tucker", 21);

        UUID uuid = UUID.randomUUID();

        Event event = this.eventService.addEvent(
                uuid,
                EventType.URGENT,
                "Test",
                "Test description",
                eventReporter,
                employee
        );

        EventReporter newEventReporter = new EventReporter("Tom", "Tucker", 33);

        System.out.println(uuid);
		this.eventService.changeEventType(event, EventType.EASY);
        this.eventService.changeEventReporter(event, newEventReporter);

        Event eventByUuid = this.eventService.getEventByUuid(uuid);

        System.out.println(eventByUuid.toString());
        System.out.println(event);
    }
}
