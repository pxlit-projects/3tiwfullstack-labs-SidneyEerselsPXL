package be.pxl.services.services;


import be.pxl.services.domain.Employee;
import be.pxl.services.domain.dto.EmployeeRequest;
import be.pxl.services.domain.dto.EmployeeResponse;

import java.util.List;

public interface IEmployeeService {

    List<EmployeeResponse> getAllEmployees();
    EmployeeResponse findById(Long id);
    List<EmployeeResponse> findByDepartment(Long depId);
    List<EmployeeResponse> findByOrganization(Long orgId);
    void addEmployee(EmployeeRequest employee);
}
