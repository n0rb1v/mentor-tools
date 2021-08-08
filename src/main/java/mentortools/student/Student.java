package mentortools.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mentortools.trainingclass.Registration;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String gituser;
    private String memo;

    @OneToMany(mappedBy = "student_id") //registration
    Set<Registration> registrations = new HashSet<>();

    public Student(String name, String email, String gituser, String memo) {
        this.name = name;
        this.email = email;
        this.gituser = gituser;
        this.memo = memo;
    }
}
