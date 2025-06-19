package urban.intership.calender.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import urban.intership.calender.DTO.EventDTO;
import urban.intership.calender.Model.Event;
import urban.intership.calender.Request.CreateEventRequest;
import urban.intership.calender.Service.EventService;

import java.util.List;

@RestController
@RequestMapping("/api/event")
public class EventController {
    @Autowired
    public EventService eventService;

    @GetMapping
    public List<Event> getAllEventDTO(){
        return eventService.getAllEvent();
    }

    @PostMapping("/create")
    public String createAndUpdateEvent(@RequestBody CreateEventRequest request){
        return eventService.createEvent(request);
    }
      public List<Event> getAllByEmail(@PathVariable String email){
        return eventService.getAllEventByEmail(email);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id){
        eventService.delete(id);
    }
}
