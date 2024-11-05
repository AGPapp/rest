package TestRest.testrest.rest.v2;

import TestRest.testrest.domain.EmployeeRepository;

import TestRest.testrest.domain.entity.Employee;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("Руководитель")
@RequestMapping("/v2/boss")
@Slf4j
public class BossController {

    @Autowired
    EmployeeRepository repository;

    @GetMapping("/bossId{bossId}")
    @Operation(summary = "получить список непосредственных подчиненных руководителя")
    public List<Employee> getEmployeesOfBoss(@RequestParam(required = true) @PathVariable Integer bossId){
        return repository.findAllByBossId(bossId);
    }

    @GetMapping("/{id}")
    @Operation(summary = "получить непосредственного руководителя сотрудника")
    public Optional<Employee> getBossOfEmployee(@PathVariable Long id){
              return repository.findById(Long.valueOf(repository.findById(id).get().getBossId()));
    }
}
