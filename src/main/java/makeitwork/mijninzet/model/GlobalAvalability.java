package makeitwork.mijninzet.model;

import javax.persistence.*;


@Entity
@Table (name = "globale_beschikbaarheid")
public class GlobalAvalability {

    //attributen
    @Transient
    public final int TOTALNUMBEROFDAYPARTS = 15;

    @Id
    @Column(name = "idGebruiker")
    private int id;
    @Column(name = "werkdag")
    private int workDay;
    @Column(name = "dagdeel")
    private int dayPart;
    @Column(name = "beschikbaar")
    private boolean avalable;

    //Hybernate mapping of the tables 2× @OneToMany with Docent and DayPart


    //no-arg constructor
    public GlobalAvalability () {}

    //all-args constructor
    public GlobalAvalability(int id, int workDay, int dayPart, boolean avalable) {
        this.id = id;
        this.workDay = workDay;
        this.dayPart = dayPart;
        this.avalable = avalable;
    }

    //method for callculating percentage of avalability
//    public double getPercentageAvalable() {
//        return count.avalable / TOTALNUMBEROFDAYPARTS;
//    }

    //getters en setters
    public int getId() { return id; }
    public int getWorkDay() { return workDay; }
    public int getDayPart() { return dayPart; }
    public boolean isAvalable() { return avalable; }

    //setters
    public void setId(int id) { this.id = id; }
    public void setWorkDay(int workDay) { this.workDay = workDay; }
    public void setDayPart(int dayPart) { this.dayPart = dayPart; }
    public void setAvalable(boolean avalable) { this.avalable = avalable; }

    //toString
    @Override
    public String toString() {
        return "globalAvalablity{" +
                "id=" + id +
                ", workDay=" + workDay +
                ", dayPart=" + dayPart +
                ", avalable=" + avalable +
                '}';
    }
}
