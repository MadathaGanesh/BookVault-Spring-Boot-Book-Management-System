package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Book;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	
	List<Book> findByBookName(String bookName);
	List<Book> findByPriceBetween(int start,int end);
	List<Book> findByAuthorContainingIgnoreCase(String author);
	List<Book> findByBookid(int bookid);
}
