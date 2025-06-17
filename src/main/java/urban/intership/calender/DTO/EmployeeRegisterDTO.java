package urban.intership.calender.DTO;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmployeeRegisterDTO {

    private String email;
    private String password;
    private String fullname;
    private String phone;
    private String address;
    private Double salary;
    private LocalDate startDate;
    private Long roleId;

}
