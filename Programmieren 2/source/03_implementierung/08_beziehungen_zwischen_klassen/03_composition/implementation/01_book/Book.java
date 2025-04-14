import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.IntStream;

@Slf4j
@Data
public class Book {
    private final String title;
    private final String author;
    private final List<Page> pages;

    public Book(String title, String author, int numberOfPages) {
        this.title = title;
        this.author = author;
        pages = IntStream.rangeClosed(1, numberOfPages)
                .mapToObj(i -> new Page(i, "content of page " + i))
                .toList();
        log.info("book '{}' created with {} pages.", title, numberOfPages);
    }

    public void displayContent() {
        log.info("displaying content of the book '{}':", title);
        pages.forEach(Page::displayContent);
    }

    public void displayPageContent(int pageNumber) {
        if (pageNumber < 1 || pageNumber > pages.size()) {
            log.error("page number {} is out of range. book has {} pages.", pageNumber, pages.size());
            return;
        }
        pages.get(pageNumber - 1).displayContent();
    }
}