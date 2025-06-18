package course.spring.streams;

import course.spring.model.Book;
import course.spring.model.MockBooks;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static course.spring.model.MockBooks.MOCK_BOOKS;

public class StreamDemo01 {
    public static void main(String[] args) {
        int[][] points = {{5,6}, {3,4}, {1,2},{7,8}};
        Arrays.stream(points)
                //.sorted(Comparator.comparing( p -> p[0] ))
        .map( p -> Math.hypot(p[0], p[1]))
               .sorted()

        .forEach( d -> System.out.println(d));

        List<Book> books = Arrays.asList(MOCK_BOOKS);
      //  Collections.sort(books, Comparator.reverseOrder());
      //  Collections.sort(books, Comparator.comparing(b -> b.getAuthor().toLowerCase()));
        books.sort(Comparator.comparing(Book::getAuthor));

        books.forEach(System.out::println);
    }
}
