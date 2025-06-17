package urban.intership.calender.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import urban.intership.calender.Model.Event;

import java.time.LocalDate;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("SELECT e FROM Event e " +
            "WHERE e.employee.id = :employeeId " +
            "AND e.day = :day " +
            "AND ((e.startTime BETWEEN :startTime AND :endTime) " +
            "OR (e.endTime BETWEEN :startTime AND :endTime) " +
            "OR (:startTime BETWEEN e.startTime AND e.endTime))")
    Event findEventsInTimeRange(
            @Param("day") LocalDate day,
            @Param("startTime") int startTime,
            @Param("endTime") int endTime,
            @Param("employeeId") Long employee_id
    );
}