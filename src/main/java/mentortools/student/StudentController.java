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
    StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "creates a movie")
    @ApiResponse(responseCode = "201",description = "movie created")
    public StudentDTO createMovie(@Valid @RequestBody CreateStudentCommand command) {
        return studentService.createStudent(command);
    }
    @GetMapping
    @Operation(summary = "list of students")
    public List<StudentDTO> listStudents(@RequestParam Optional<String> search) {
        return studentService.listActors(search);
    }
}
