package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.entity.Book;
import com.demo.repository.BookRepository;
import com.demo.service.BookService;

@Controller
public class BookController {

    private final BookRepository bookRepository;


		@Autowired
		private BookService bookservice;

    BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

		@GetMapping("/")
		public String homepage() {
			return "home";
		}

		
		@GetMapping("/getallbooks")
		@ResponseBody
		public List<Book> getAllBooks(){
			return bookservice.getAllBooks();
		}
		
		@PostMapping("/addsinglebook")
		@ResponseBody
		public Book saveBook(@RequestBody Book book) {
			return bookservice.AddSingleBook(book);
		}
		
		@PostMapping("/addmultiplebooks")
		@ResponseBody
		public List<Book> saveMultipleBooks(@RequestBody List<Book> multipleBooks) {
			return bookservice.addMultipleBooks(multipleBooks);
		}
		
		@DeleteMapping("/removebook/{id}")
		public void removeBook(@PathVariable int id) {
			bookservice.RemoveBook(id);
		}
		
		@GetMapping("/bookname/{bookname}")
		@ResponseBody
		public List<Book> getbyBookName(@PathVariable String bookname) {
			return bookservice.findByBookName(bookname);
		}
		
		@GetMapping("/pricebetween/{lowprice}/{highprice}")
		@ResponseBody
		public List<Book> getbyPriceBetween(@PathVariable("lowprice") int lowprice, @PathVariable("highprice") int highprice){
			return bookservice.findByPriceBetween(lowprice, highprice);
		}
	
		@GetMapping("/authorName/{authorName}")
		@ResponseBody
		public List<Book> getByAuthor(@PathVariable String authorName){
			return bookservice.findByAuthor(authorName);
		}
		
		
		
		@PutMapping("/updatebook/{bookid}")
		public Book updateBookDetails(@PathVariable int bookid, @RequestBody Book updatedbookdetails) {
			return bookservice.UpdateBook(bookid, updatedbookdetails);
		}
}

