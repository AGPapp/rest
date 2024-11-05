package TestRest.testrest.rest.v2;


import TestRest.testrest.bussines.SalaryService;

import TestRest.testrest.dto.Employee;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/v2/salary/")

public class SalaryController {


    @Autowired
    private SalaryService salaryService;

    @GetMapping("/max/departament{departamentId}")
    @Operation(operationId = "maxSalaryEmployeeInDep", summary = "Максимальная зарплата")
    Employee maxSalaryEmployeeInDepartament(@PathVariable Long departamentId){
        return salaryService.maxSalaryEmployeeInDepartment(departamentId)
                .orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Отдел или сотрудник не найден"));
    }
    @GetMapping("/maxsall")
    @Operation(summary = "получить список сотрудников, чья месячная заработная плата непосредственно больше, чем у их руководителей")
    List<TestRest.testrest.domain.entity.Employee> EmployeesSalaryMoreThanBoss(){
        return salaryService.salaryMoreThanBoss();
    }
}