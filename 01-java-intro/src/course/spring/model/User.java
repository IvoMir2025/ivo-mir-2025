package course.spring.model;

import java.time.LocalDate;

import static course.spring.model.Role.*;

public class User extends Person{
    private String username;
    private String password;
    private Role role = READER;
    private String email;

    public User() {
        super();  /* super(); */
    }

    public User(String firstName, String lastName, String username, String password) {
        super(firstName, lastName);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{"  +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", birthDate='" + getBirthDate() + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", email='" + email + '\'' +
                "} " ;
    }

    public User(String firstName, String lastName, LocalDate birthDate, String username, String password, Role role, String email) {
        super(firstName, lastName, birthDate);
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
    }

    public User(Long id, String firstName, String lastName, LocalDate birthDate, String username, String password, Role role, String email) {
        super(id, firstName, lastName, birthDate);
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
    }
}

