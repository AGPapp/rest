package TestRest.testrest.bussines;

import TestRest.testrest.domain.entity.Employee;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
class HelloTest {
    @Qualifier("")
    @Autowired
          HelloHi he;

    @Autowired
    Employee employee;
    @Test
    void sayHello() {
        he.sayHello(employee);
    }
}