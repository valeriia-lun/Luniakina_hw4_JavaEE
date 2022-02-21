package com.javaee.web.starter.controller;

import com.javaee.web.starter.model.Book;
import com.javaee.web.starter.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

  private final BookService booksService;

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<List<Book>> saveBook(@RequestBody final Book book) {
    booksService.saveBook(book);

    return ResponseEntity
        .status(HttpStatus.OK)
        .body(booksService.getAllBooks());
  }

  @RequestMapping(value = "/filter", method = RequestMethod.POST)
  public ResponseEntity<List<Book>> findBooks(@RequestBody final Book book) {
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(booksService.getBooksByNameAndIsbn(book.getName(), book.getISBN()));
  }

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<Book>> getAll() {
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(booksService.getAllBooks());
  }
}
