package urban.intership.calender.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tên chức vụ không được để trống")
    @Size(max = 50, message = "Tên chức vụ  không được vượt quá 50 ký tự")
    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @Size(max = 255, message = "Mô tả không được vượt quá 255 ký tự")
    @Column(length = 255)
    private String description;

//    @OneToMany(mappedBy = "role")
//    private List<Employee> employees;
}