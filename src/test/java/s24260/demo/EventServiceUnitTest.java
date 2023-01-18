package s24260.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EventServiceUnitTest {
    @Mock
    EventStorage eventStorage;

    @InjectMocks
    EventService eventService;

    @Test
    void changeEventType() {
        //given
        Event event = new Event(null, EventType.NORMAL, "", "", null, null);
        System.out.println(event);

        when(eventStorage.getEventByUuid(any())).thenReturn(event);

        //when
        eventService.changeEventType(event, EventType.EASY);

        //then
        assertThat(event.getType()).isEqualTo(EventType.EASY);
    }

    @Test
    void changeEventReporter() {
        //given
        Event event = new Event(UUID.randomUUID(), EventType.NORMAL, "", "", null, null);
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
        Event event = new Event(UUID.randomUUID(), EventType.NORMAL, "", "", null, null);
        when(eventStorage.getEventByUuid(any())).thenReturn(event);

        //when
        Event returnedEvent = eventService.getEventByUuid(event.getUuid());

        //then
        assertThat(returnedEvent.getUuid()).isEqualTo(event.getUuid());
    }
}