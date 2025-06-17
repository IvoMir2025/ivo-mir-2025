import course.spring.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("John", "Smith", "r","g"));
        users.add(new User("Ivan", "Petrov", "g","d"));
        users.add(new User("Maria", "Hristova", "g","g"));
  //      users.forEach(System.out::println);

        for(User u : users){
            System.out.println(u);
        }
        System.out.println("=================================");
        for(int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }
    }
}