package in.kanhajava.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(
        description = "EmployeeDto Model Information"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long id;

    @Schema(
            description = "Employee First Name"
    )
    @NotEmpty(message = "User first name should not be null or empty !!")
    private String firstName;

    @Schema(
            description = "Employee Last Name"
    )
    @NotEmpty(message = "User last name should not be null or empty !!")
    private String lastName;

    @Schema(
            description = "Employee Email"
    )
    @NotEmpty(message = "User mail id should not be null or empty !!")
    @Email(message = "Email should be valid !!")
    private String email;

    @Schema(
            description = "Employee Department Code"
    )
    private String departmentCode;

    @Schema(
            description = "Employee Organization Code"
    )
    private String organizationCode;
}
