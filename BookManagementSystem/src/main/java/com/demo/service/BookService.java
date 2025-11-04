package com.demo.service;

import java.util.List;
import com.example.demo.BookManagementSystemApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.entity.Book;
import com.demo.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookrepository;
  
	public List<Book> getAllBooks(){
		return bookrepository.findAll();
	}
	
	public Book AddSingleBook(Book newBookDetails) {
		return bookrepository.save(newBookDetails);
	}
	
	public void RemoveBook(int bookid) {
		 bookrepository.deleteById(bookid);
	}
	
	public List<Book> findByBookName (String bookName){
		return bookrepository.findByBookName(bookName);
	}
	
	public List<Book> findByPriceBetween(int lowprice, int highPrice){
		return bookrepository.findByPriceBetween(lowprice, highPrice);
	}
	
	public List<Book> findByAuthor(String authorName){
		return bookrepository.findByAuthorContainingIgnoreCase(authorName);
	}
	
	public List<Book> addMultipleBooks(List<Book> multiplebooks){
		return bookrepository.saveAll(multiplebooks);
	}
	
	// Code for updating book details , PUT Method
	public Book UpdateBook(int bookid, Book updateBookDetails) {
		return bookrepository.findById(bookid).map(bookdetails -> {
			bookdetails.setBookName(updateBookDetails.getBookName());
			bookdetails.setAuthor(updateBookDetails.getAuthor());
			bookdetails.setPrice(updateBookDetails.getPrice());
			return bookrepository.save(bookdetails);
		}).orElseThrow(() -> new RuntimeException("Book not found with this book ID : " +bookid));
			
			

	}
	
}
