package urban.intership.calender.Service;

import urban.intership.calender.DTO.EmployeeDTO;
import urban.intership.calender.DTO.EmployeeRegisterDTO;
import urban.intership.calender.Model.Employee;
import urban.intership.calender.Request.LoginRequest;

import java.util.List;

public interface EmployeeService {

    Employee registerEmployee(EmployeeRegisterDTO dto);
    String login(LoginRequest loginRequest);



    List<EmployeeDTO> getAllEmployees();

    Employee getEmployeeById(Long id);

    void deleteEmployee(Long id);

    Employee updateEmployee(Long id, EmployeeRegisterDTO dto);

}