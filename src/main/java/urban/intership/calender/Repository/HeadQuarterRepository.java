package urban.intership.calender.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import urban.intership.calender.Model.Headquarter;

public interface HeadQuarterRepository extends JpaRepository<Headquarter, Long> {
}