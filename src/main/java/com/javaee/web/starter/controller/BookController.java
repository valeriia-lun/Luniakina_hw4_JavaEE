package com.javaee.web.starter.controller;

import com.javaee.web.starter.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
  List<Book> books = new ArrayList<>();

  @GetMapping("/index")
  public String getBooksPage() {
    return "books-form-page";
  }

  @PostMapping()
  public String createBook(@ModelAttribute Book book) {
    books.add(book);
    return "redirect:/books";
  }

  @GetMapping()
  public String getBooks(Model model) {
    model.addAttribute("books", books);
    return "books";
  }
}
