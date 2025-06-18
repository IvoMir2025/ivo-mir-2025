package course.spring.streams;

import course.spring.model.Book;
import course.spring.model.MockBooks;

import java.util.Arrays;
import java.util.Comparator;

import static course.spring.model.MockBooks.MOCK_BOOKS;

public class StreamDemo02 {
    public static void main(String[] args) {

        var books = Arrays.stream(MOCK_BOOKS);
        books
                .filter( book -> book.getTitle().toLowerCase().contains("java"))
                .map(Book::getTitle)
                .sorted(Comparator.comparing(String::toLowerCase))
                .forEach(System.out::println);
    }
}
