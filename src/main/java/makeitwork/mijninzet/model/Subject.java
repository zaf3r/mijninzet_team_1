package makeitwork.mijninzet.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "vak")
public class Subject {

    @Id
    @Column(name = "codeVak")
    int subjectId;

    @Column(name = "naamvak")
    String subjectName;

    @OneToMany(mappedBy = "subject")
    private Set<Preference> preferenceSet;

}
