package makeitwork.mijninzet.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vak")
public class Subject {

    @Id
    @Column(name = "codevak")
    int subjectId;

    @Column(name = "naamvak")
    String subjectName;

    @OneToMany(mappedBy = "subject")
    private Set<Preference> preferenceSet = new HashSet<>();

}
