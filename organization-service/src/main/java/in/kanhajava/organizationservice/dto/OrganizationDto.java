package in.kanhajava.organizationservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Schema(
        description = "OrganizationDto Model Information"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDto {
    private Long id;

    @Schema(
            description = "Organization Name"
    )
    private String organizationName;

    @Schema(
            description = "Organization Description"
    )
    private String organizationDescription;

    @Schema(
            description = "Organization Code"
    )
    private String organizationCode;
    private LocalDateTime creationDate;
}
