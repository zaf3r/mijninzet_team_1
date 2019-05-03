package makeitwork.mijninzet.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "gebruiker")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idgebruiker")
    private int id;

    @Column(name = "wachtwoord")
    private String password;

    @Column(name = "gebruikersnaam")
    private String username;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "rollen_gebruiker", joinColumns = @JoinColumn(name = "idgebruiker"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private List<Role> role;

    public User() {
    }

    public User(User user) {
        this.role = user.getRole();
        this.username = user.getUsername();
        this.id = user.getId();
        this.password = user.getPassword();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }
}
