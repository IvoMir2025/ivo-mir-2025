package course.spring.init;

import course.spring.domain.ArticleService;
import course.spring.domain.CategoryService;
import course.spring.domain.UserService;
import course.spring.model.Article;
import course.spring.model.Category;
import course.spring.model.Role;
import course.spring.model.User;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Log
public class DbInitializer implements ApplicationRunner {
    @Autowired
    private ApplicationContext ctx;

    private static final List<User> USERS = List.of(
            new User(1L, "Dimitar", "Petrov", LocalDate.of(1978, 5, 17),
                    "ivan", "Ivan123", Role.READER, "ivan@gmail.com"),
            new User(2L, "John", "Smith", LocalDate.of(1982, 7, 3),
                    "sjohn", "John123", Role.AUTHOR, "john@gmail.com"),
            new User(3L, "Mary", "Smith", LocalDate.of(1985, 4, 21),
                    "mary", "Mary123", Role.ADMIN, "mary@yahoo.com"),
            new User(4L, "Zornica", "Dimitrova", LocalDate.of(1987, 4, 17),
                    "moni", "Mary123", Role.READER, "mony@yahoo.com"),
            new User(5L, "Dimitar", "Dimitrov", LocalDate.of(1987, 4, 17),
                    "moni2", "Mary123", Role.AUTHOR, "mony2@yahoo.com"),
            new User(6L, "Monica", "Dimitrova", LocalDate.of(1987, 4, 17),
                    "moni3", "Mary123", Role.ADMIN, "mony3@yahoo.com"),
            new User(7L, "Maya", "Smith", LocalDate.of(1984, 8, 8),
                    "maya", "Mary123", Role.READER, "maya@yahoo.com"),
            new User(8L, "Maya", "Hristova", LocalDate.of(1987, 7, 29),
                    "maya2", "Mary123", Role.READER, "mayah@yahoo.com")
    );

    private static final List<Category> CATEGORIES = List.of(
            new Category("Java", "Java programming"),
            new Category("Database", "Database persistence"),
            new Category("Machine Learning", "Machine learning models and libraries")
    );

    private static final List<Article> ARTICLES = List.of(
            new Article("Spring Data JPA Intro",
                    "Generally, the query creation mechanism for JPA works as described in Query Methods.",
                    Set.of("java", "spring", "data", "jpa")),
            new Article("Hibernate & JPA ORM",
                    "Hibernate, as an ORM solution, effectively \"sits between\" the Java application data access layer and the Relational Database, as can be seen in the diagram above.",
                    Set.of("java", "hibernate", "data", "jpa", "orm")),
            new Article("Spring Core Introduction",
                    "Foremost amongst these is the Spring Framework’s Inversion of Control (IoC) container.",
                    Set.of("java", "spring", "ioc", "bean", "context", "container"))
    );

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ArticleService articleService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //sample users
        if(userService.getUsersCount() == 0) {
            USERS.forEach(userService::addUser);
        }
        var users = userService.getAllUsers();
        // sample categories
        if(categoryService.getCategoriesCount() == 0) {
            CATEGORIES.forEach(categoryService::addCategory);
        }
        var categories = categoryService.getAllCategories();

        // sample articles
        if(articleService.getArticlesCount() == 0) {
            ARTICLES.forEach(article -> {
                article.setAuthor(users.getFirst());
                article.setEditor(users.getLast());
                article.getCategories().add(categories.get(0));
                article.getCategories().add(categories.get(1));
                articleService.addArticle(article);
            });
        }

    }
}
