import course.spring.model.Person;
import course.spring.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static course.spring.model.Role.*;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new User("John", "Smith", "r","g"));
        persons.add(new User("Ivan", "Petrov", "g","d"));
        persons.add(new Person("Ned", "Dim",LocalDate.of(1984,8,19)));
        persons.add(new User("Maya", "Dimitrova", LocalDate.of(1984,8,19), "g","g", ADMIN, "m@gmail.com"));
  //      persons.forEach(System.out::println);

        for(Person u : persons){
            System.out.println(u);
        }
        System.out.println("=================================");
        for(int i = 0; i < persons.size(); i++) {
            System.out.println(persons.get(i));
        }
    }
}