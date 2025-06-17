package urban.intership.calender.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import urban.intership.calender.Enums.RequestStatus;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Businesstrip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employeeName;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "headpuarter_id")
    private Headquarter place; // Trụ sở có sẵn

    @Column(length = 255)
    private String otherPlace; // Nơi công tác tùy chỉnh

    @Column(length = 500)
    private String descriptionTrip;

    @Column(length = 255)
    private String transportation;

    @Enumerated(EnumType.STRING)
    private RequestStatus status;
}