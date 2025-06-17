package urban.intership.calender.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Worktype {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Mã loại công việc (workMode) không được để trống")
    @Size(max = 100, message = "Mã loại công việc không được vượt quá 100 ký tự")
    @Column(nullable = false, unique = true, length = 100)
    private String workMode; // VD: "OFFICE", "REMOTE", "TRIP", "LEAVE"

    @Size(max = 500, message = "Mô tả không được vượt quá 500 ký tự")
    @Column(length = 500)
    private String description;

    @OneToMany(mappedBy = "workType")
    private List<Event> events;
}
