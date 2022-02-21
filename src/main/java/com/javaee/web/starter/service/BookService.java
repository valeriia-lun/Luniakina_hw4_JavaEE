package com.javaee.web.starter.service;

import com.javaee.web.starter.model.Book;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookService {
  List<Book> booksStorage = new ArrayList<>();

  public void saveBook(Book book) {
    booksStorage.add(book);
    log.info("A new was added {}", book);
  }

  public List<Book> getAllBooks() {
    return booksStorage;
  }

  public List<Book> getBooksByNameAndIsbn(String name, String isbn) {
    return booksStorage.stream()
        .filter(book -> book.getISBN().contains(isbn) || book.getName().contains(name))
        .collect(Collectors.toList());
  }
}
