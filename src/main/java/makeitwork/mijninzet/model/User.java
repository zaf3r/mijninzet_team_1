package makeitwork.mijninzet.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "gebruiker")
public class User {

    private final String VERPLICHT=" is een verplicht veld";
    private final int MIN_PWD=8;
    private final String COLUMN_PASSWORD="wachtwoord";
    private final String COLUMN_USERNAME="gebruikersnaam";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idgebruiker")
    private int id;

    @NotNull(message=COLUMN_PASSWORD+VERPLICHT)
    @Size(min=MIN_PWD, message= "minimale lengte van een password is "+MIN_PWD)
    @Column(name = COLUMN_PASSWORD)
    private String password;

    @NotNull(message=COLUMN_USERNAME+VERPLICHT)
    @Column(name = COLUMN_USERNAME)
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
