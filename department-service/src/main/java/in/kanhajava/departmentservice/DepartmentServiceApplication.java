package in.kanhajava.departmentservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(
		info = @Info(
				title = "Department Service REST APIs",
				description = "Department Service REST APIs Documentation Here.",
				version = "v1.0",
				contact = @Contact(
						name = "Kanha",
						email = "kanharouta@gmail.com",
						url = "https/www.kanhajava.com"
				),
				license = @License(
						name = "Kanha 2.5",
						url = "https/www.kanhajava.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Department-service Doc",
				url = "https/www.kanhajava.com"
		)

)
@SpringBootApplication
public class DepartmentServiceApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
