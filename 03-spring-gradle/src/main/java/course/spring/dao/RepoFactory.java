package course.spring.dao;

public interface RepoFactory {
    UserRepository getUserRepository(IdGenerator idGenerator);
}
