package in.kanhajava.employeeservice.service;

import in.kanhajava.employeeservice.dto.APIResponseDto;
import in.kanhajava.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);

}
