package urban.intership.calender.Service;

import org.springframework.stereotype.Service;
import urban.intership.calender.DTO.EventDTO;
import urban.intership.calender.Model.Event;
import urban.intership.calender.Request.CreateEventRequest;

import java.util.List;

@Service
public interface EventService {
    List<Event> getAllEvent();
    String createEvent(CreateEventRequest request);
    void delete(Long id);
}