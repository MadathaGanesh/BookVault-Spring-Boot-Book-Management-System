package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.demo.entity.Book;
import com.demo.service.BookService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@SpringBootApplication(scanBasePackages = {"com.demo.service","com.demo.controller"})
@EnableJpaRepositories(basePackages  = {"com.demo.repository"})
@EntityScan(basePackages = {"com.demo.entity"})
public class BookManagementSystemApplication implements CommandLineRunner{
	
	@Autowired
	private BookService bookservice;

	public static void main(String[] args) {
		SpringApplication.run(BookManagementSystemApplication.class, args);
		
	}


	@Override
	public void run(String... args) throws Exception {
		Book SingleBook = new Book("Can we be Strangers Again?", "Rishi", 350);

		
		
		Book book1 = new Book("To Kill a Mockingbird", "Harper Lee",399);
		Book book2 = new Book("1984", "George Orwell", 299);
		Book book3 = new Book("Pride and Prejudice", "Jane Austen", 349);
		Book book4 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 279);
		Book book5 = new Book("The Hobbit", "J.R.R. Tolkien", 459);
		Book book6 = new Book("The Catcher in the Rye", "J.D. Salinger", 319);
		Book book7 = new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 499);
		Book book8 = new Book("The Alchemist", "Paulo Coelho", 299);
		Book book9 = new Book("The Da Vinci Code", "Dan Brown", 399);
		Book book10 = new Book("The Lord of the Rings", "J.R.R. Tolkien", 799);
		
		List<Book> allbooks = List.of(book1,book2,book3,book4,book5,book6,book7,book8,book9,book10);
		bookservice.addMultipleBooks(allbooks);
		for (Book b : allbooks) {
			System.out.println("Book Id is : " +b.getBookid() );
		}
		
		
		
//		// saving single book data to database
		bookservice.AddSingleBook(SingleBook);
		System.out.println("Book saved with ID : " + SingleBook.getBookid());
	}

}
