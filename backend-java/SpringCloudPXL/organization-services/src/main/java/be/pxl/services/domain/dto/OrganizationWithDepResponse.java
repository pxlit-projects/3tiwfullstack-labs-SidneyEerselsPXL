package be.pxl.services.domain.dto;

import be.pxl.services.domain.Department;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationWithDepResponse {
    private String name;
    private String address;
    private List<Department> departments;
}
