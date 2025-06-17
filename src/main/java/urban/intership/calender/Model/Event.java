package urban.intership.calender.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Ngày không được để trống")
    @Column(nullable = false)
    private LocalDate day;

    @NotNull(message = "Thời gian bắt đầu không được để trống")
    @Column(nullable = false)
    private int startTime;

    @NotNull(message = "Thời gian kết thúc không được để trống")
    @Column(nullable = false)
    private int endTime;

    @Size(max = 255, message = "Nội dung công việc không được vượt quá 255 ký tự")
    @Column(length = 255)
    private String taskDescription;

    @Size(max = 20, message = "Trạng thái không được vượt quá 20 ký tự")
    @Column(length = 20)
    private String status;



    @NotNull(message = "Nhân viên không được để trống")
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @NotNull(message = "Trụ sở làm việc không được để trống")
    @ManyToOne
    @JoinColumn(name = "headquarter_id", nullable = false)
    private Headquarter workplace;

    @NotNull(message = "Loại công việc không được để trống")
    @ManyToOne
    @JoinColumn(name = "work_type_id", nullable = false)
    private Worktype workType;

}