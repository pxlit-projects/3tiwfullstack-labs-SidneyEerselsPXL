package be.pxl.services.services;

import be.pxl.services.domain.Organization;
import be.pxl.services.domain.dto.*;
import be.pxl.services.repository.OrganizationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class OrganizationService implements  IOrganizationService {
    private final OrganizationRepository repository;

    private Organization findOrganizationById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Organization with id " + id + " not found!"));

    }


    @Override
    public OrganizationResponse findById(Long id) {
        Organization organization = findOrganizationById(id);
        return OrganizationResponse.builder()
                .name(organization.getName())
                .address(organization.getAddress())
                .build();
    }

    @Override
    public OrganizationWithDepResponse findByIdWithDepartments(Long id) {
        Organization organization = findOrganizationById(id);
        return OrganizationWithDepResponse.builder()
                .name(organization.getName())
                .address(organization.getAddress())
                .departments(organization.getDepartments())
                .build();
    }

    @Override
    public OrganizationWithDepAndEmpResponse findByIdWithDepartmentsAndEmployees(Long id) {
        Organization organization = findOrganizationById(id);
        return OrganizationWithDepAndEmpResponse.builder()
                .name(organization.getName())
                .address(organization.getAddress())
                .departments(organization.getDepartments())
                .employees(organization.getEmployees())
                .build();
    }

    @Override
    public OrganizationWithEmpResponse findByIdWithEmployees(Long id) {
        Organization organization = findOrganizationById(id);

        return OrganizationWithEmpResponse.builder()
                .name(organization.getName())
                .address(organization.getAddress())
                .employees(organization.getEmployees())
                .build();
    }
}
