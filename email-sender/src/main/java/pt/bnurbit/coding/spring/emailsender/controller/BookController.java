package pt.bnurbit.coding.spring.emailsender.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pt.bnurbit.coding.spring.model.Book;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class BookController {

    private static Map<Integer, Book> bookStore = new HashMap<>();

    static {
        Book book1 = new Book(123, "Alice in Wonderland", "Lewis Carrol");
        Book book2 = new Book(456, "Anna Karenina", "Leo Tolstoy");
        bookStore.put(book1.getId(), book1);
        bookStore.put(book2.getId(), book2);
    }

    @RequestMapping
    public String welcome(){
        return "<h2> Welcome to the bookstore! </h2>";
    }

    @RequestMapping(value = "/book")
    public ResponseEntity<Object> getBook(@RequestParam("bookId") Integer bookId){

        log.info("Retrieving book...");
        return new ResponseEntity<>(bookStore.get(bookId), HttpStatus.OK);
    }
}
