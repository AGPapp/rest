package TestRest.testrest.rest.v1;


import TestRest.testrest.domain.entity.Employee;
import TestRest.testrest.domain.EmployeeRepository;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController ("Управление сотрудниками v1")
@RequestMapping("/v1/employees")
@Slf4j
public class EmpoyeeController {
    @Autowired
    private EmployeeRepository repository;

   @GetMapping
    Iterable<Employee> getAll() {
        return repository.findAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(operationId = "addEmp", summary = "Добавить нового сотрудника")
    Employee newEmployee(@RequestBody Employee employee) {
        log.info("-----------------------------------------------------");
        if(employee.getId() != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"ID найден. Используй PUT для изменения записи");
        return repository.save(employee);
    }
    @GetMapping("/{id}")
    Employee getById(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }



}
