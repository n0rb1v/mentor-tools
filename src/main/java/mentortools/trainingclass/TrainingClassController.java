package mentortools.trainingclass;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import mentortools.student.CreateStudentCommand;
import mentortools.student.StudentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/trainingclasses")
public class TrainingClassController {
    private final TrainingClassService trainingClassService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "creates a trainingclass")
    @ApiResponse(responseCode = "201",description = "trainingclass created")
    public TrainingClassDTO createMovie(@Valid @RequestBody CreateRegistrationCommand command) {
        return trainingClassService.createRegistration(command);
    }
}
