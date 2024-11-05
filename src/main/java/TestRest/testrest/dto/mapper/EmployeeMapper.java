package TestRest.testrest.dto.mapper;

import TestRest.testrest.dto.Employee;
import org.mapstruct.Mapper;

@Mapper
public interface EmployeeMapper {
Employee toDto (TestRest.testrest.domain.entity.Employee employee);
}