package course.spring.io;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilesDemo01 {
    public static void main(String[] args) throws IOException {
        var source = Paths.get("./src/course/spring/io", "FilesDemo01.java")
                .toAbsolutePath()
                .normalize();
        System.out.printf("File '%s' exists: %b\n", source, Files.exists(source));
        var charset = Charset.forName("utf8");
        var lines = Files.lines(source,charset);
        lines.forEach((System.out::println));
    }
}
