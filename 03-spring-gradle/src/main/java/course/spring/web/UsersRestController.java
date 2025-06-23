package course.spring.web;

import course.spring.dao.UserRepository;
import course.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

import static org.antlr.v4.runtime.misc.Utils.count;

@RestController
@RequestMapping("/api/users")
public class UsersRestController {
    @Autowired
    private UserRepository userRepo;

   /* @GetMapping
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @GetMapping
    public Optional<User> getUserByID() {
        return userRepo.findById(3L);
    } */

   @GetMapping
    public long getUsersCount() {
        return userRepo.count();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    //public User addUser(@RequestBody User user) {
    //  return userRepo.create(user);
    public ResponseEntity<User> addUser(@RequestBody User user) {
        var newUser = userRepo.create(user);
        return ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequestUri().pathSegment("{id}")
                        .buildAndExpand(newUser.getId()).toUri())
                        .body(newUser);
    }
}
