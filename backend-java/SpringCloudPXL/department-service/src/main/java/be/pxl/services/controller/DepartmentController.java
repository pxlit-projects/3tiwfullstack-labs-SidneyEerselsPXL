package be.pxl.services.controller;


import be.pxl.services.domain.dto.DepartmentRequest;
import be.pxl.services.domain.dto.DepartmentResponse;
import be.pxl.services.domain.dto.DepartmentWithEmployees;
import be.pxl.services.services.IDepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final IDepartmentService departmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void CreateDepartment(@RequestBody @Valid DepartmentRequest department) {
        departmentService.addDepartment(department);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DepartmentResponse GetDepartment(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DepartmentResponse> GetAllDepartments() {
        return departmentService.getAllDepartments();
    }
    @GetMapping("/organization/{organizationId}")
    public List<DepartmentResponse> GetDepartmentByOrganizationId(@PathVariable Long organizationId) {
        return departmentService.getDepartmentByOrganization(organizationId);
    }
    @GetMapping("/organization/{organizationId}/with-employees")
    public List<DepartmentWithEmployees> findByOrganizationWithEmployees(@PathVariable Long organizationId) {
        return departmentService.getByOrganizationWithEmployees(organizationId);
    }
}
