package mentortools.student;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "creates a student")
    @ApiResponse(responseCode = "201",description = "student created")
    public StudentDTO createMovie(@Valid @RequestBody CreateStudentCommand command) {
        return studentService.createStudent(command);
    }
    @GetMapping
    @Operation(summary = "list of students")
    public List<StudentDTO> listStudents(@RequestParam Optional<String> search) {
        return studentService.listActors(search);
    }
    @PutMapping("/{id}")
    @Operation(summary = "update student")
    public StudentDTO updateMovie(@PathVariable("id") long id, @Valid @RequestBody CreateStudentCommand command){
        return studentService.updateStudent(id,command);
    }
}
