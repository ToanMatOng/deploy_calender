package urban.intership.calender.Service.ServiceImpl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import urban.intership.calender.DTO.EmployeeDTO;
import urban.intership.calender.DTO.EmployeeRegisterDTO;
import urban.intership.calender.Model.Employee;
import urban.intership.calender.Model.Role;
import urban.intership.calender.Repository.EmployeeRepository;
import urban.intership.calender.Repository.RoleRepository;
import urban.intership.calender.Request.LoginRequest;
import urban.intership.calender.Service.EmployeeService;
import urban.intership.calender.Utils.JWTUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Getter
@Setter
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTUtils jwtUtils;
    private final CustomUserDetailsServiceImpl customUserDetailsService;


    @Override
    public Employee registerEmployee(EmployeeRegisterDTO dto) {

        if (employeeRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email đã được sử dụng");
        }

        Role role = roleRepository.findById(dto.getRoleId())
                .orElseThrow(() -> new RuntimeException("Vai trò không tồn tại"));

        Employee employee = new Employee();
        employee.setEmail(dto.getEmail());
        employee.setPassword(passwordEncoder.encode(dto.getPassword())); // Mã hoá password
        employee.setFullname(dto.getFullname());
        employee.setPhone(dto.getPhone());
        employee.setAddress(dto.getAddress());
        employee.setSalary(dto.getSalary());
        employee.setStartDate(dto.getStartDate());
        employee.setRole(role);

        return employeeRepository.save(employee);
    }

    @Override
    public String login(LoginRequest loginRequest) {
        // Tìm employee theo email
        Employee employee = employeeRepository.findByEmail(loginRequest.email())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        // So sánh password (vì bạn đã mã hóa BCrypt khi lưu)
        if (!passwordEncoder.matches(loginRequest.password(), employee.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        // Load UserDetails từ email
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(employee.getEmail());

        // Tạo token
        String token = jwtUtils.generateToken(userDetails);

        return token;
    }

    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream().map(emp -> {
            EmployeeDTO dto = new EmployeeDTO();
            dto.setId(emp.getId());
            dto.setFullname(emp.getFullname());
            dto.setEmail(emp.getEmail());
            dto.setPhone(emp.getPhone());
            dto.setRoleName(emp.getRole().getName());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployee(Long id, EmployeeRegisterDTO dto) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        employee.setEmail(dto.getEmail());
        employee.setPassword(passwordEncoder.encode(dto.getPassword()));
        employee.setFullname(dto.getFullname());
        employee.setPhone(dto.getPhone());
        employee.setAddress(dto.getAddress());
        employee.setSalary(dto.getSalary());
        employee.setStartDate(dto.getStartDate());
        employee.setRole(roleRepository.findById(dto.getRoleId())
                .orElseThrow(() -> new RuntimeException("Role not found")));

        return employeeRepository.save(employee);
    }
}
