package stream.stream_objects;

import java.util.List;

import static stream.util.getBooksList;

public class AllNoneMatchFindFirstAny {
    public static void main(String[] args) {
        List<Book> books = getBooksList();
        boolean result = books.stream().allMatch(b -> b.getPages() > 2000);
        System.out.println(result);

        boolean resultNoneMatch = books.stream().noneMatch(b -> b.getPages() > 100);
        System.out.println(resultNoneMatch);

        books.stream().filter(b -> b.getType() == Type.HISTORY).findAny()
                .ifPresent(System.out::println);

    }
}
