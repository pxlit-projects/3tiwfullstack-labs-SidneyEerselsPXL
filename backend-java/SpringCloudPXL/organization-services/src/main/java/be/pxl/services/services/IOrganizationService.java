package be.pxl.services.services;

import be.pxl.services.domain.dto.OrganizationResponse;
import be.pxl.services.domain.dto.OrganizationWithDepAndEmpResponse;
import be.pxl.services.domain.dto.OrganizationWithDepResponse;
import be.pxl.services.domain.dto.OrganizationWithEmpResponse;

public interface IOrganizationService {
    OrganizationResponse findById(Long id);
    OrganizationWithDepResponse findByIdWithDepartments(Long id);
    OrganizationWithDepAndEmpResponse findByIdWithDepartmentsAndEmployees(Long id);
    OrganizationWithEmpResponse findByIdWithEmployees(Long id);
}
