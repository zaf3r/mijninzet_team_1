package makeitwork.mijninzet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
public class IncidentalAvalability {

    @Id
    @Column
    private int idGebruiker;
    @Id
    @Column
    private Date date;
    @Id
    @Column
    private int dayPart;
    @Column
    private boolean notAvalable;

    //no-arg
    public IncidentalAvalability () {}

    //all-arg
    public IncidentalAvalability(int idGebruiker, Date date, int dayPart, boolean notAvalable) {
        this.idGebruiker = idGebruiker;
        this.date = date;
        this.dayPart = dayPart;
        this.notAvalable = notAvalable;
    }

    //Getters
    public int getIdGebruiker() { return idGebruiker; }
    public Date getDate() { return date; }
    public int getDayPart() { return dayPart; }
    public boolean isNotAvalable() { return notAvalable; }

    //setters
    public void setIdGebruiker(int idGebruiker) { this.idGebruiker = idGebruiker; }
    public void setDate(Date date) { this.date = date; }
    public void setDayPart(int dayPart) { this.dayPart = dayPart; }
    public void setNotAvalable(boolean notAvalable) { this.notAvalable = notAvalable; }

    //toString
    @Override
    public String toString() {
        return "incidentalAvalability{" +
                "idGebruiker=" + idGebruiker +
                ", date=" + date +
                ", dayPart=" + dayPart +
                ", notAvalable=" + notAvalable +
                '}';
    }

}
