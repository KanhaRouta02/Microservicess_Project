package in.kanhajava.departmentservice.controller;

import in.kanhajava.departmentservice.dto.DepartmentDto;
import in.kanhajava.departmentservice.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Department Service - DepartmentController",
        description = "Department Controller Exposes REST APIs for Department-Service"
)
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Operation(
            summary = "Save Department REST API",
            description = "Save Department REST API is user to save department object in a Database."
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping()
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto savedDepartments = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartments, HttpStatus.OK);
    }

    @Operation(
            summary = "Get Department REST API",
            description = "Get Department REST API is user to get a department object from the Database."
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    // Get department by department code
    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCODE(@PathVariable("department-code") String code) {
        DepartmentDto departmentByCode = departmentService.getDepartmentByCode(code);
        return new ResponseEntity<>(departmentByCode, HttpStatus.OK);
    }
}
