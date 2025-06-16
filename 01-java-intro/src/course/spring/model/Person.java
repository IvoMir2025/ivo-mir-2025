package course.spring.model;

import java.time.LocalDate;

public class Person {
    Long id;
    String firstName;
    String lasrName;
    LocalDate birthDate = LocalDate.now();
}
