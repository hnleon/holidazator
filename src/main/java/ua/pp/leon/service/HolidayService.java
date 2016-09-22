package ua.pp.leon.service;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ua.pp.leon.domain.Holiday;
import ua.pp.leon.domain.HolidayRepository;

/**
 *
 * @author Andrii Zalevskyi <azalevskyi@gmail.com>
 */
@Service
public class HolidayService {

    private final HolidayRepository holidayRepository;
    private final MessageSource messageSource;

    @Autowired
    public HolidayService(HolidayRepository holidayRepository, MessageSource messageSource) {
        this.holidayRepository = holidayRepository;
        this.messageSource = messageSource;
    }

    public Set<Holiday> findByHolidayDateBetween(Date from, Date to, Locale locale) {
        Set<Holiday> result = new TreeSet<>();
        Set<Holiday> holidays = holidayRepository.findByHolidayDateBetween(from, to);
        injectWeekends(holidays, from, to, locale);
        result.addAll(holidays);
        return result;
    }

    protected void injectWeekends(Set<Holiday> holidays, Date from, Date to, Locale locale) {
        final String SATURDAY = messageSource.getMessage("day.saturday", null, locale);
        final String SUNDAY = messageSource.getMessage("day.sunday", null, locale);
        Calendar current = Calendar.getInstance();
        current.setTime(from);
        current.set(Calendar.HOUR_OF_DAY, 0); // Includes last day from range in: current.before(lastDay)
        Calendar lastDay = Calendar.getInstance();
        lastDay.setTime(to);
        lastDay.set(Calendar.HOUR_OF_DAY, 23); // Includes last day from range in: current.before(lastDay)

        while (current.before(lastDay)) {
            final Holiday h;
            switch (current.get(Calendar.DAY_OF_WEEK)) {
                case Calendar.SATURDAY:
                    h = new Holiday(current.getTime(), SATURDAY);
                    break;
                case Calendar.SUNDAY:
                    h = new Holiday(current.getTime(), SUNDAY);
                    break;
                default:
                    h = null;
            }
            if (h != null) {
                holidays.add(h);
            }
            current.add(Calendar.DAY_OF_MONTH, 1);
        }
    }
}
