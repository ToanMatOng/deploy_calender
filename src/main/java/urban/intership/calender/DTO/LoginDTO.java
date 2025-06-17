package urban.intership.calender.DTO;

import lombok.Data;
import urban.intership.calender.Model.Employee;

import java.util.List;

@Data
public class LoginDTO {
    private int statusCode;
    private String error;
    private String message;
    private String token;
    private String refreshToken;
    private String expirationTime;
    private String fullname;
    private String address;
    private String role;
    private String email;
    private String password;
    private Employee employees;
    private List<Employee> employeeList;
}
