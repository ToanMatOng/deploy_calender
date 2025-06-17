package urban.intership.calender.Request;

import java.time.LocalDate;
import java.time.LocalTime;

public record CreateEventRequest(LocalDate day,
                                 Long employee_id,
                                 Long workplace_id,
                                 Long workType_id,
                                 int startTime,
                                 int endTime,
                                 String taskDescription,
                                 String status) {
}