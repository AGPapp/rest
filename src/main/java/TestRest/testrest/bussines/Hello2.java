package TestRest.testrest.bussines;

import TestRest.testrest.domain.entity.Employee;
import org.slf4j.Logger;


public class Hello2 implements HelloHi {

    private Logger log;

    public Hello2(Logger log) {
        this.log = log;
    }

    @Override
    public void sayHello(Employee employee){
        log.info("Hello test version TEST "+ employee.getFirstName());
    }
}
