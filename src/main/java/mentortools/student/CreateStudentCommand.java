package mentortools.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateStudentCommand {
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    private String gituser;
    private String memo;
}
