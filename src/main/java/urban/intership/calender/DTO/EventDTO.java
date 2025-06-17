package urban.intership.calender.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EventDTO {
    private Long id;
    private Long employee;
    private Long workplace;
    private Long workType;
    private LocalDate day;
    private int startTime;
    private int endTime;
    private String taskDescription;
    private String status;
}