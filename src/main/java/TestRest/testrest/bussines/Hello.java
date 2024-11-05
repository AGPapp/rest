package TestRest.testrest.bussines;

import TestRest.testrest.domain.entity.Employee;
import org.slf4j.Logger;


public class Hello implements HelloHi {

    private Logger log;

    public Hello(Logger log) {
        this.log = log;
    }

    @Override
    public void sayHello(Employee employee){
        log.info("Hello "+ employee.getFirstName());
    }
}
