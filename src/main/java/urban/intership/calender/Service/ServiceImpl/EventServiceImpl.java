package urban.intership.calender.Service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import urban.intership.calender.Model.Employee;

import urban.intership.calender.Model.Event;
import urban.intership.calender.Model.Headquarter;
import urban.intership.calender.Model.Worktype;
import urban.intership.calender.Repository.EmployeeRepository;
import urban.intership.calender.Repository.EventRepository;
import urban.intership.calender.Repository.HeadQuarterRepository;
import urban.intership.calender.Repository.WorkTypeRepository;
import urban.intership.calender.Request.CreateEventRequest;
import urban.intership.calender.Service.EventService;

import java.util.List;
import java.util.Optional;


@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private WorkTypeRepository workTypeRepository;
    @Autowired
    private HeadQuarterRepository headQuarterRepository;

    @Override
    public List<Event> getAllEvent() {
        return eventRepository.findAll();
    }

    private boolean checkEventIfExistReturnFalse(CreateEventRequest request){
        //find all event in this day and time
        Event checkEventTime=eventRepository.findEventsInTimeRange(request.day(),request.startTime(),request.endTime(), request.employee_id());
        if (checkEventTime!= null)return false;
        return true;
    }


    @Override
    public String createEvent(CreateEventRequest request) {
        try {
            //check employee, work type, work place if not exist return error
            Optional<Employee> checkEmployee= employeeRepository.findById(request.employee_id());
            if (checkEmployee.isEmpty())return "User is not exist";
            Optional<Worktype> checkWorkType= workTypeRepository.findById(request.workType_id());
            if (checkWorkType.isEmpty())return "Work type is not exist";
            Optional<Headquarter> checkWorkPlace= headQuarterRepository.findById(request.workplace_id());
            if (checkWorkPlace.isEmpty())return "Work place is not exist";
            if (checkEventIfExistReturnFalse(request)==true) {
                Event newEvent = new Event();
                newEvent.setDay(request.day());
                newEvent.setStartTime(request.startTime());
                newEvent.setEndTime(request.endTime());
                newEvent.setTaskDescription(request.taskDescription());
                newEvent.setStatus(request.status());
                newEvent.setEmployee(checkEmployee.get());
                newEvent.setWorkplace(checkWorkPlace.get());
                newEvent.setWorkType(checkWorkType.get());

                 eventRepository.save(newEvent);
            }
            return "Created/Updated";
        }catch (Exception e){
            return "Some thing wrong: "+e.getMessage();
        }
    }
      @Override
    public List<Event> getAllEventByEmail(String email) {
        Optional<Employee> employee= employeeRepository.findByEmail(email);
        return employee.get().getEvents();
    }


    @Override
    public void delete(Long id) {
        eventRepository.deleteById(id);
    }
}
