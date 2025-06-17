package urban.intership.calender.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import urban.intership.calender.Model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}