package urban.intership.calender.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import urban.intership.calender.Model.Worktype;

import java.util.Optional;

public interface WorkTypeRepository extends JpaRepository<Worktype, Long> {
    Optional<Worktype> findByWorkMode(String workMode);
}