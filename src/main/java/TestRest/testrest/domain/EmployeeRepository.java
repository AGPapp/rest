package TestRest.testrest.domain;

import TestRest.testrest.domain.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



import java.util.List;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

   List<Employee> findAllByFirstName(String firstName);

    List<TestRest.testrest.domain.entity.Employee> findAllByBossId(Integer bossId);
}