package ua.pp.leon;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StatementsValidationTests {

    private static final Logger LOG = Logger.getLogger(StatementsValidationTests.class.getName());

    GregorianCalendar c;

    @Before
    public void init() {
        c = (GregorianCalendar) GregorianCalendar.getInstance();
    }

    /**
     * 1 января 1900 года - понедельник.
     */
    @Test
    public void januaryFirst1990() {
        c.set(1990, Calendar.JANUARY, 1);
        assertEquals(Calendar.MONDAY, c.get(Calendar.DAY_OF_WEEK));
    }

    /**
     * В сентябре, апреле, июне и ноябре 30 дней. В феврале 28, в високосный год - 29. В остальных
     * месяцах по 31 дню.
     */
    @Test
    public void commonYear() {
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.YEAR, 2015);

        c.set(Calendar.MONTH, Calendar.APRIL);
        assertEquals(30, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        c.set(Calendar.MONTH, Calendar.JUNE);
        assertEquals(30, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        c.set(Calendar.MONTH, Calendar.SEPTEMBER);
        assertEquals(30, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        c.set(Calendar.MONTH, Calendar.NOVEMBER);
        assertEquals(30, c.getActualMaximum(Calendar.DAY_OF_MONTH));

        c.set(Calendar.MONTH, Calendar.FEBRUARY);
        assertEquals(28, c.getActualMaximum(Calendar.DAY_OF_MONTH));

        c.set(Calendar.MONTH, Calendar.JANUARY);
        assertEquals(31, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        c.set(Calendar.MONTH, Calendar.MARCH);
        assertEquals(31, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        c.set(Calendar.MONTH, Calendar.MAY);
        assertEquals(31, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        c.set(Calendar.MONTH, Calendar.JULY);
        assertEquals(31, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        c.set(Calendar.MONTH, Calendar.AUGUST);
        assertEquals(31, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        c.set(Calendar.MONTH, Calendar.OCTOBER);
        assertEquals(31, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        c.set(Calendar.MONTH, Calendar.DECEMBER);
        assertEquals(31, c.getActualMaximum(Calendar.DAY_OF_MONTH));
    }

    /**
     * В сентябре, апреле, июне и ноябре 30 дней. В феврале 28, в високосный год - 29. В остальных
     * месяцах по 31 дню.
     */
    @Test
    public void leapYear() {
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.YEAR, 2016);

        c.set(Calendar.MONTH, Calendar.APRIL);
        assertEquals(30, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        c.set(Calendar.MONTH, Calendar.JUNE);
        assertEquals(30, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        c.set(Calendar.MONTH, Calendar.SEPTEMBER);
        assertEquals(30, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        c.set(Calendar.MONTH, Calendar.NOVEMBER);
        assertEquals(30, c.getActualMaximum(Calendar.DAY_OF_MONTH));

        c.set(Calendar.MONTH, Calendar.FEBRUARY);
        assertEquals(29, c.getActualMaximum(Calendar.DAY_OF_MONTH));

        c.set(Calendar.MONTH, Calendar.JANUARY);
        assertEquals(31, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        c.set(Calendar.MONTH, Calendar.MARCH);
        assertEquals(31, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        c.set(Calendar.MONTH, Calendar.MAY);
        assertEquals(31, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        c.set(Calendar.MONTH, Calendar.JULY);
        assertEquals(31, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        c.set(Calendar.MONTH, Calendar.AUGUST);
        assertEquals(31, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        c.set(Calendar.MONTH, Calendar.OCTOBER);
        assertEquals(31, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        c.set(Calendar.MONTH, Calendar.DECEMBER);
        assertEquals(31, c.getActualMaximum(Calendar.DAY_OF_MONTH));
    }

    /**
     * Високосный год - любой год, делящийся нацело на 4, однако первый год века (ХХ00) является
     * високосным в том и только том случае, если делится на 400.
     */
	@Test
	public void leapYearCheck() {
        for (int year = 1582; year <= c.get(Calendar.YEAR); year++) {
            LOG.log(Level.INFO, "Testing year: {0}", year);
            boolean leapByDividing = (year & 3) == 0 && ((year % 25) != 0 || (year & 15) == 0);
            assertEquals(c.isLeapYear(year), leapByDividing);
        }
	}
}
