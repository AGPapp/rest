package TestRest.testrest.config;

import TestRest.testrest.bussines.Hello;
import TestRest.testrest.bussines.Hello2;
import TestRest.testrest.bussines.HelloHi;
import TestRest.testrest.domain.entity.Employee;
import lombok.extern.slf4j.Slf4j;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;



@Configuration
@Slf4j
public class HelloConfig {
    @Bean
    @Profile("!test")
    HelloHi getHeImpl() {
        return new Hello(log);
    }
    @Bean
    @Profile("test")
    HelloHi getHeImpl2() {
        return new Hello2(log);
    }
    @Bean
Employee makeDefEmpl(){
        return new Employee(null,"Васиий",null,null,null,null,null,null);
}
}
