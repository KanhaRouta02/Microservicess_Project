package in.kanhajava.employeeservice.service;

import in.kanhajava.employeeservice.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ORGANIZATION-SERVICE")
public interface OrganizationAPIClient {
    @GetMapping("api/organizations/{code}")
    OrganizationDto getOrganizationByCode(@PathVariable("code") String organizationCode);
}
