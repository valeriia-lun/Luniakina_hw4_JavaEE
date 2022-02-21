package com.javaee.web.starter.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AppController {
  @RequestMapping()
  public String index() {
    return "index";
  }
}
