package TestRest.testrest;



import TestRest.testrest.domain.entity.Course;
import TestRest.testrest.domain.entity.Department;
import TestRest.testrest.domain.entity.Employee;
import TestRest.testrest.domain.EmployeeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


import jakarta.transaction.Transactional;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


import java.time.LocalDate;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(value = false)
@ActiveProfiles("test")
class DbTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    EmployeeRepository employeeRepository;

    @BeforeEach
    void setup() {
        Department department = new Department(null, "IT",null);
        Course course = new Course(null, "REST service");
        Employee emp = new Employee(null,"a","b",null,12,16, 123213123,13);

        em.persist(department);
        em.persist(course);
        em.persist(emp);
    }

    @Test
    void test() {
        Assert.assertEquals(1, em.createQuery("FROM Department").getResultList().size());
        Employee emp = em.createQuery("FROM Employee", Employee.class)
                .setMaxResults(1)
                .getResultList()
                .get(0);
        Assert.assertEquals("REST service",emp.getCourses().get(0).getName());
    }
    @Test
    void test2(){
        Employee emp = employeeRepository.findAllByFirstName("a").get(0);
       Assert.assertEquals("REST service",emp.getCourses().get(0).getName());
    }
}