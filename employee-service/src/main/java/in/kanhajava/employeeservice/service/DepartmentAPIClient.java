package in.kanhajava.employeeservice.service;

import in.kanhajava.employeeservice.dto.DepartmentDto;
import in.kanhajava.employeeservice.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "http://localhost:8080", value = "DEPARTMENT-SERVICE")
@FeignClient(name = "DEPARTMENT-SERVICE")
public interface DepartmentAPIClient {
    @GetMapping("api/departments/{department-code}")
    DepartmentDto getDepartmentByCODE(@PathVariable("department-code") String code) ;


}
