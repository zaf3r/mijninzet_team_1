package makeitwork.mijninzet.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "voorkeur")
public class Preference implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "idvak_fk")
    private Subject subject;

    @Id
    @ManyToOne
    @JoinColumn(name = "idgebruiker_fk")
    private User user;

    @Column(name = "voorkeur")
    private int preference;

    public Preference(){
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getPreference() {
        return preference;
    }

    public void setPreference(int preference) {
        this.preference = preference;
    }
}
