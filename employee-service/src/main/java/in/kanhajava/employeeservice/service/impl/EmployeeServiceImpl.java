package in.kanhajava.employeeservice.service.impl;

import in.kanhajava.employeeservice.dto.APIResponseDto;
import in.kanhajava.employeeservice.dto.DepartmentDto;
import in.kanhajava.employeeservice.dto.EmployeeDto;
import in.kanhajava.employeeservice.dto.OrganizationDto;
import in.kanhajava.employeeservice.entity.Employee;
import in.kanhajava.employeeservice.exception.EmailAlreadyExistException;
import in.kanhajava.employeeservice.exception.ResourceNotFoundException;
import in.kanhajava.employeeservice.repository.EmployeeRepository;
import in.kanhajava.employeeservice.service.DepartmentAPIClient;
import in.kanhajava.employeeservice.service.EmployeeService;
import in.kanhajava.employeeservice.service.OrganizationAPIClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper ;

//    @Autowired
//    private RestTemplate restTemplate;

//    @Autowired
//    private WebClient webClient;
    @Autowired
    private DepartmentAPIClient departmentAPIClient;

    @Autowired
    private OrganizationAPIClient organizationAPIClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Optional<Employee> byEmail = employeeRepository.findByEmail(employeeDto.getEmail());
        if(byEmail.isPresent()) {
            throw new EmailAlreadyExistException("Email already exist of id : " + byEmail.get().getId());
        }
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto = modelMapper.map(savedEmployee, EmployeeDto.class);
        return savedEmployeeDto;
    }

    @CircuitBreaker(name = "${spring.application.name}",fallbackMethod = "getDefaultDepartment")
    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("USER", "ID", employeeId)
                );

//        // Rest Template
//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(),
//                DepartmentDto.class);
//        DepartmentDto departmentDto = responseEntity.getBody();

//        // WebClient
//        DepartmentDto departmentDto = webClient.get().uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();

        // FeignClient
        DepartmentDto departmentDto = departmentAPIClient.getDepartmentByCODE(employee.getDepartmentCode());
        OrganizationDto organizationDto = organizationAPIClient.getOrganizationByCode(employee.getOrganizationCode());
//        OrganizationDto organizationDto = null;
        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        apiResponseDto.setOrganization(organizationDto);
        return apiResponseDto;
    }

    public APIResponseDto getDefaultDepartment(Long employeeId, Exception e ){
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("USER", "ID", employeeId)
        );

        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentName("R&D Department");
        departmentDto.setDepartmentName("RD001");
        departmentDto.setDepartmentDescription("Research and Development Department");

        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        return apiResponseDto;
    }
}
