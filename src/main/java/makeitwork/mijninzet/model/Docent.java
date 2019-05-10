package makeitwork.mijninzet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Docent extends User {


    @Id
    @Column
    private int id;

    //Hybernate mapping of the tables 2× @ManyToOne with IncidentalAvalability & GlobalAvalability


    //no-args
    public Docent() { }

    //all-args
    public Docent(int id) { this.id = id; }

    //getters
    @Override
    public int getId() {
        return id;
    }

    //setters
    @Override
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
