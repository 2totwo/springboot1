package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final BookService bookService;

    // http://localhost:8081/home
    @GetMapping("/home")
    public String home(){
        return "home"; // home.html
    }

    // 책 목록
    @GetMapping("/list")
    public String findAll(Model model){
        List<Book> books=bookService.findAll();
        model.addAttribute("books", books);
        return "list"; // list.html
    }

    // 책 삭제
    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id){
        bookService.deleteById(id);
        return "redirect:/list";
    }

    // 책 등록 화면 이동
    @GetMapping("/register")
    public String register(){
        return "register"; // register.html
    }

    // 책 등록
    @PostMapping("/register")
    public String register(Book book){
        bookService.save(book);
        return "redirect:/list";
    }
    
    // 책 상세보기
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model){
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "detail"; // detail.html
    }

    // 책 수정 화면 이동
    @GetMapping("/modify/{id}")
    public String modify(@PathVariable Long id, Model model){
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "modify"; // modify.html
    }

    // 책 수정
    @PostMapping("/modify/{id}")
    public String modify(@PathVariable Long id, Book book){ // book.id(2) -> id가 있으면 update, 없으면 ?
        bookService.update(id, book);
        return "redirect:/list";
    }
}
