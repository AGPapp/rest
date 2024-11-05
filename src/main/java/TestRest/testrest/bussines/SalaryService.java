package TestRest.testrest.bussines;

import TestRest.testrest.domain.entity.Department;
import TestRest.testrest.domain.DepartmentRepository;
import TestRest.testrest.domain.EmployeeRepository;

import TestRest.testrest.domain.entity.Employee;
import TestRest.testrest.dto.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class SalaryService {

    @Autowired
    private DepartmentRepository repository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper mapper;


    public Optional<TestRest.testrest.dto.Employee> maxSalaryEmployeeInDepartment(Long departmentId) {
        Optional<Department> departmentOpt = repository.findById(departmentId);
        if (departmentOpt.isEmpty() || departmentOpt.get().getEmployees().isEmpty()) {
            return Optional.empty();
        }
        Employee employee = departmentOpt.get().getEmployees().stream()
                .max(Comparator.comparing(Employee::getMonthSalary)).get();
        return Optional.of(mapper.toDto(employee));
    }
    public List<Employee> salaryMoreThanBoss(){
        List<Employee> employees = new ArrayList<>();

        Iterable<Employee> employeesAll = employeeRepository.findAll();

        for (Employee val:employeesAll){
            if (val.getBossId()==null) continue;

            Integer employeeSalary = val.getMonthSalary();
            Integer bossId = val.getBossId();
            Integer bossSalary = employeeRepository.findById(Long.valueOf(bossId)).get().getMonthSalary();

            if (employeeSalary>bossSalary) employees.add(val);
        }

        return employees;
    }

}
