package urban.intership.calender.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không hợp lệ")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;

    @NotBlank(message = "Tên không được để trống")
    @Size( max = 100, message = "Tên không được vượt quá 100 ký tự")
    private String fullname;



    @NotBlank(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "^[0-9]{10,15}$",
            message = "Số điện thoại chỉ chứa số và từ 10 đến 15 chữ số")
    private String phone;

    @NotBlank(message = "Địa chỉ không được để trống")
    @Size(max = 255, message = "Địa chỉ không được vượt quá 255 ký tự")
    private String address;

    @Column(nullable = false)
    @Positive(message = "Salary must be positive")
    private Double salary; // lương cơ bản

    @Column(nullable = false)
    @PastOrPresent(message = "Start date cannot be in the future")
    private LocalDate startDate; // ngày bắt đầu làm việc

    @ManyToOne
    @JoinColumn(name = "role_id")
    @NotNull(message = "Vai trò không được để trống")
    private Role role; //  chức vụ

    @OneToMany(mappedBy = "employee")
    private List<Event> events;

    @OneToMany(mappedBy = "employeeName")
    private List<Businesstrip> businesstrips;

    @OneToMany(mappedBy = "employeeName")
    private List<Applicationleave> applicationleaves;
}