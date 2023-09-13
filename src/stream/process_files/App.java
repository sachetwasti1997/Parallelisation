package stream.process_files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) throws IOException {
        var path = "/home/sachet/IdeaProjects/Parallelisation/src/stream/process_files/names";
        Stream<String> names = Files.lines(Paths.get(path));
        names.forEach(System.out::println);
    }
}
