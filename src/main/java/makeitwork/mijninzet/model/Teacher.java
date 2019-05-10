package makeitwork.mijninzet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="docentt")
public class Teacher {


    @Id
    @Column(name="idGebruiker")
    private int id;

    //Hybernate mapping of the tables 2× @ManyToOne with IncidentalAvalability & GlobalAvalability


    //no-args
    public Teacher() { }

    //all-args
    public Teacher(int id) { this.id = id; }

    //getters
    public int getId() {
        return id;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    //toString
    @Override
    public String toString() {
        return "Docent{" +
                "id=" + id +
                '}';
    }
}
