package in.kanhajava.employeeservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@OpenAPIDefinition(
		info = @Info(
				title = "Employee Service REST APIs",
				description = "Employee Service REST APIs Documentation Here.",
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
				description = "Employee-service Doc",
				url = "https/www.kanhajava.com"
		)

)
@SpringBootApplication
@EnableFeignClients
public class EmployeeServiceApplication {


	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

//	// Rest Template
//	@Bean
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}

//	// WebClient
//	@Bean
//	public WebClient webClient() {
//		return WebClient.builder().build();
//	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
