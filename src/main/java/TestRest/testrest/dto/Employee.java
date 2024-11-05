package TestRest.testrest.dto;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
@Getter

public class Employee {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private Integer monthSalary;
    private Integer bossid;
}