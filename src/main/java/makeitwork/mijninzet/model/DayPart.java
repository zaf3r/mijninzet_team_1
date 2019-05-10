package makeitwork.mijninzet.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "dagdeel")
public class DayPart {

    @Id
    @Column
    private int workday;
    @Id
    @Column
    private int daypart;


    //Hybernate mapping of the tables 1× @OneToMany with table GlobalAvalability

    @Transient
    private String dayPartValue;

    @Transient
    List<DayPart> getDayPartValues = Arrays.asList(
            new DayPart("monday1", 1, 1),
            new DayPart("monday2", 1, 2),
            new DayPart("monday3", 1, 3),
            new DayPart("tuesday1", 2, 1),
            new DayPart("tuesday2", 2, 2),
            new DayPart("tuesday3", 2, 3),
            new DayPart("wednesday1", 3, 1),
            new DayPart("wednesday2", 3, 2),
            new DayPart("wednesday3", 3, 3),
            new DayPart("thursday1", 4, 1),
            new DayPart("thursday2", 4, 2),
            new DayPart("thursday3", 4, 3),
            new DayPart("friday1", 5, 1),
            new DayPart("friday2", 5, 2),
            new DayPart("friday3", 5, 3)
    );

    //no-arg
    public DayPart() { }

    //all-arg2
    public DayPart(String dayPartValue, int workday, int daypart) {
        this.dayPartValue = dayPartValue;
        this.workday = workday;
        this.daypart = daypart;
    }

    //all-args1
    public DayPart(int workday, int daypart) {
        this.workday = workday;
        this.daypart = daypart;
    }

    //getters
    public String getDayPartValue() { return dayPartValue; }
    public int getWorkday() { return workday; }
    public int getDaypart() { return daypart; }

    //setters
    public void setDayPartValue(String dayPartValue) { this.dayPartValue = dayPartValue; }
    public void setWorkday(int workday) { this.workday = workday; }
    public void setDaypart(int daypart) { this.daypart = daypart; }

    //toString

    @Override
    public String toString() {
        return "DayPart{" +
                "workday=" + workday +
                ", daypart=" + daypart +
                '}';
    }
}
