package urban.intership.calender.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import urban.intership.calender.DTO.EmployeeRegisterDTO;
import urban.intership.calender.Model.Employee;
import urban.intership.calender.Request.LoginRequest;
import urban.intership.calender.Service.EmployeeService;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final EmployeeService employeeService;

    @Autowired
    public AuthController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/register")
    public ResponseEntity<Employee> registerEmployee(@Valid @RequestBody EmployeeRegisterDTO employeeRegisterDTO) {
        Employee registeredEmployee = employeeService.registerEmployee(employeeRegisterDTO);
        return new ResponseEntity<>(registeredEmployee, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            String token = employeeService.login(loginRequest);
            return ResponseEntity.ok(Map.of(
                    "token", token,
                    "message", "Đăng nhập thành công"
            ));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
