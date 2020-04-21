package com.pbasco.mvc.services;

import java.util.List;
import java.util.Optional;

//...
import org.springframework.stereotype.Service;
import com.pbasco.mvc.models.Book;
import com.pbasco.mvc.repositories.BookRepository;
@Service
public class BookService {
 // adding the book repository as a dependency
	private final BookRepository bookRepository;
 
 public BookService(BookRepository bookRepository) {
     this.bookRepository = bookRepository;
 }
 // returns all the books
 public List<Book> allBooks() {
     return bookRepository.findAll();
 }
 // creates a book
 public Book createBook(Book b) {
     return bookRepository.save(b);
 }
 // retrieves a book
 public Book findBook(Long id) {
     Optional<Book> optionalBook = bookRepository.findById(id);
     if(optionalBook.isPresent()) {
         return optionalBook.get();
     } else {
         return null;
     }
 }
public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
	Optional <Book> temp = bookRepository.findById(id);
	if(temp != null) {
		temp.get().setTitle(title);
		temp.get().setDescription(desc);
		temp.get().setLanguage(lang);
		temp.get().setNumberOfPages(numOfPages);
		
		return temp.get();
	}
	return null;
}

public void deleteBook(Long id) {
	// TODO Auto-generated method stub
	bookRepository.deleteById(id);

	
}
}

