package course.spring.init;

import course.spring.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DbInitializer implements ApplicationRunner {

    @Autowired
    private UserRepository userRepo;

    @Override
    public void run(App)
}
