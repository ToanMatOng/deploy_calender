package urban.intership.calender.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import urban.intership.calender.Model.Employee;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    boolean existsByEmail(String email);
    Optional<Employee> findByEmail(String email);


}
