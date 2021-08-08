package mentortools.student;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepo studentRepo;
    private final ModelMapper modelMapper;

    public List<StudentDTO> listActors(Optional<String> search) {
        return studentRepo.findAll().stream()
                .filter(actor -> search.isEmpty() || actor.getName().toLowerCase().contains(search.get().toLowerCase()))
                .map(actor -> modelMapper.map(actor,StudentDTO.class))
                .collect(Collectors.toList());
    }
    public StudentDTO createStudent(CreateStudentCommand command) {
        Student student = new Student(
                command.getName(),
                command.getEmail(),
                command.getGituser(),
                command.getMemo());
        studentRepo.save(student);
        return modelMapper.map(student,StudentDTO.class);
    }
    @Transactional
    public StudentDTO updateStudent(long id, CreateStudentCommand command) {
        Student student = studentRepo.findById(id).orElseThrow(() -> new IllegalArgumentException());
        student.setName(command.getName());
        student.setEmail(command.getEmail());
        student.setGituser(command.getGituser());
        student.setMemo(command.getMemo());
        return modelMapper.map(student,StudentDTO.class);
    }
    public void deleteMovie(long id) {
        studentRepo.deleteById(id);
    }
}
