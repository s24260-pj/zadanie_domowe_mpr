package s24260.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class EventServiceIntegrationTest {
    @MockBean
    EventStorage eventStorage;

    @Autowired
    EventService eventService;

    @Test
    void changeEventType() {
        //given
        Event event = new Event(null, EventType.NORMAL, "", "", null, null);
        when(eventStorage.getEventByUuid(any())).thenReturn(event);

        //when
        eventService.changeEventType(event, EventType.EASY);

        //then
        assertThat(event.getType()).isEqualTo(EventType.EASY);
    }

    @Test
    void changeEventReporter() {
        //given
        Event event = new Event(null, EventType.NORMAL, "", "", null, null);
        EventReporter eventReporter = new EventReporter("", "", null);

        when(eventStorage.getEventByUuid(any())).thenReturn(event);

        //when
        eventService.changeEventReporter(event, eventReporter);

        //then
        assertThat(event.getEventReporter()).isEqualTo(eventReporter);
    }

    @Test
    void getEventByUuid() {
        //given
        Event event = new Event(null, EventType.NORMAL, "", "", null, null);
        when(eventStorage.getEventByUuid(any())).thenReturn(event);

        //when
        Event returnedEvent = eventService.getEventByUuid(event.getUuid());

        //then
        assertThat(returnedEvent.getUuid()).isEqualTo(event.getUuid());
    }
}