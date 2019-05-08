package makeitwork.mijninzet.model;

import javax.persistence.*;


@Entity
@Table (name = "globale_beschikbaarheid")
public class GlobalAvalablity {

    //attributen
    @Id
    @Column(name = "idGebruiker")
    private int idGebruiker;
    @Id
    @Column(name = "workDay")
    private int workDay;
    @Id
    @Column(name = "dayPart")
    private int dayPart;
    @Column(name = "avalable")
    private boolean avalable;


    //no-arg constructor
    public GlobalAvalablity () {}

    //all-args constructor
    public GlobalAvalablity(int idGebruiker, int workDay, int dayPart, boolean avalable) {
        this.idGebruiker = idGebruiker;
        this.workDay = workDay;
        this.dayPart = dayPart;
        this.avalable = avalable;
    }

    //getters en setters
    public int getIdGebruiker() { return idGebruiker; }
    public int getWorkDay() { return workDay; }
    public int getDayPart() { return dayPart; }
    public boolean isAvalable() { return avalable; }

    //setters
    public void setIdGebruiker(int idGebruiker) { this.idGebruiker = idGebruiker; }
    public void setWorkDay(int workDay) { this.workDay = workDay; }
    public void setDayPart(int dayPart) { this.dayPart = dayPart; }
    public void setAvalable(boolean avalable) { this.avalable = avalable; }

    //toString
    @Override
    public String toString() {
        return "globalAvalablity{" +
                "idGebruiker=" + idGebruiker +
                ", workDay=" + workDay +
                ", dayPart=" + dayPart +
                ", avalable=" + avalable +
                '}';
    }
}
