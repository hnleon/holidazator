package ua.pp.leon.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Andrii Zalevskyi <azalevskyi@gmail.com>
 */
@Entity
@Table(name = "holidays")
public class Holiday implements Serializable, Comparable<Holiday> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    protected Long id;
    @NotNull
    @Column(name = "holi_date", nullable = false, unique = true)
    @Temporal(TemporalType.DATE)
    protected Date holidayDate;
    @NotNull
    @Column(nullable = false)
    private String name;

    public Holiday() {
    }

    public Holiday(Date holidayDate) {
        this.holidayDate = holidayDate;
    }

    public Holiday(Date holidayDate, String name) {
        this.holidayDate = holidayDate;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    protected void setId(Long id) {
        this.id = id;
    }

    public Date getHolidayDate() {
        return holidayDate;
    }

    public void setHolidayDate(Date holidayDate) {
        this.holidayDate = holidayDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Holiday o) {
        return this.holidayDate.compareTo(o.holidayDate);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.holidayDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Holiday other = (Holiday) obj;
        if (!Objects.equals(this.holidayDate, other.holidayDate)) {
            return false;
        }
        return true;
    }
}
