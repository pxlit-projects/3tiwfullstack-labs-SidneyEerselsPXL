package be.pxl.services.services;

import be.pxl.services.domain.Department;
import be.pxl.services.domain.dto.DepartmentRequest;
import be.pxl.services.domain.dto.DepartmentResponse;
import be.pxl.services.domain.dto.DepartmentWithEmployees;

import java.util.List;

public interface IDepartmentService {
    void addDepartment(DepartmentRequest department);
    DepartmentResponse getDepartmentById(Long id);
    List<DepartmentResponse> getAllDepartments();
    List<DepartmentResponse> getDepartmentByOrganization(Long organizationId);
    List<DepartmentWithEmployees> getByOrganizationWithEmployees(Long organizationId);

}
