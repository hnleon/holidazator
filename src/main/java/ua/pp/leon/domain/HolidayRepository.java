package ua.pp.leon.domain;

import java.util.Date;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andrii Zalevskyi <azalevskyi@gmail.com>
 */
@Repository
public interface HolidayRepository extends JpaRepository<Holiday, Long> {

    Set<Holiday> findByHolidayDateBetween(Date from, Date to);
}
