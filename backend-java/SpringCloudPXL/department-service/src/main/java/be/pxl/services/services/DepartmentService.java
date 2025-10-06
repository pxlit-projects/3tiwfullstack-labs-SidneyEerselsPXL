package be.pxl.services.services;

import be.pxl.services.domain.Department;
import be.pxl.services.domain.dto.DepartmentRequest;
import be.pxl.services.domain.dto.DepartmentResponse;
import be.pxl.services.domain.dto.DepartmentWithEmployees;
import be.pxl.services.repository.DepartmentRepository;
import jakarta.persistence.EntityNotFoundException;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService implements IDepartmentService{
    private final DepartmentRepository departmentRepository;

    private DepartmentResponse mapToResponse(Department department) {
        return DepartmentResponse.builder()
                .name(department.getName())
                .organizationId(department.getOrganizationId())
                .position(department.getPosition())
                .build();
    }
    private DepartmentWithEmployees getDepartmentWithEmployees(Department department) {
        return DepartmentWithEmployees.builder()
                .name(department.getName())
                .organizationId(department.getOrganizationId())
                .position(department.getPosition())
                .employees(department.getEmployees())
                .build();
    }
    @Override
    public void addDepartment(DepartmentRequest department) {
        Department newDepartment = Department.builder()
                .name(department.getName())
                .organizationId(department.getOrganizationId())
                .position(department.getPosition())
                .build();
        departmentRepository.save(newDepartment);
    }

    @Override
    public DepartmentResponse getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Department not found"));
        return mapToResponse(department);
    }

    @Override
    public List<DepartmentResponse> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map(this::mapToResponse).toList();
    }

    @Override
    public List<DepartmentResponse> getDepartmentByOrganization(Long organizationId) {
        List<Department> departments = departmentRepository.findByOrganization(organizationId);
        if (departments.isEmpty()) {
            throw new EntityNotFoundException("This organization does not have a department");
        }
        return departments.stream().map(this::mapToResponse).toList();
    }

    @Override
    public List<DepartmentWithEmployees> getByOrganizationWithEmployees(Long organizationId) {
        List<Department> departments = departmentRepository.findByOrganization(organizationId);
        if (departments.isEmpty()) {
            throw new EntityNotFoundException("This organization does not have a department");
        }
        return departments.stream().map(this::getDepartmentWithEmployees).toList();

    }
}
