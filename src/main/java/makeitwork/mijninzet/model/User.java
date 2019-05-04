package makeitwork.mijninzet.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "gebruiker")
public class User {

    //Validation fields
    @Transient
    private final String VERPLICHT=" is een verplicht veld";

    @Transient
    private final int MIN_PWD=8;


    //Column names of entity
    @Transient
    private final String COLUMN_PASSWORD="wachtwoord";

    @Transient
    private final String COLUMN_USERNAME="gebruikersnaam";

    @Transient
    private final String COLUMN_ID = "idgebruiker";

    @Transient
    private final String COLUMN_ACTIVE = "actief";

    //Constant variables that represent other table names/columns
    @Transient
    private final String JOINT_TABLE_NAME = "rollen_gebruiker";

    @Transient
    private final String PK_COLUMN_OTHER_ENTITY = "rol_id";


    //Fields that are mapped by Hibernate
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

    @NotNull(message = COLUMN_ACTIVE+VERPLICHT)
    @Column(name = COLUMN_ACTIVE)
    private int active;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = JOINT_TABLE_NAME,
            joinColumns = @JoinColumn(name = COLUMN_ID),
            inverseJoinColumns = @JoinColumn(name = PK_COLUMN_OTHER_ENTITY))
    private List<Role> role;

    public User() {
    }

    public User(User user) {
        this.role = user.getRole();
        this.username = user.getUsername();
        this.id = user.getId();
        this.password = user.getPassword();
        this.active = user.getActive();
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

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
