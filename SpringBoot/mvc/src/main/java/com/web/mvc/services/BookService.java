package com.web.mvc.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.web.mvc.models.Book;
import com.web.mvc.repositories.BookRepository;

@Service
public class BookService {
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
    // update a book
    public Book updateBook(Long id, String title, String desc, String lang, int numOfPages) {
    	Optional<Book> optionalBook = bookRepository.findById(id);
    	if(optionalBook.isPresent()) {
    		System.out.println("BOOKSERVICE.JAVA / UPDATEBOOK() optionalBook.get(): "+optionalBook.get());
    		optionalBook.get().setTitle(title);
    		optionalBook.get().setDescription(desc);
    		optionalBook.get().setLanguage(lang);
    		optionalBook.get().setNumberOfPages(numOfPages);
    		optionalBook.get().setUpdatedAt(new Date());
    		bookRepository.save(optionalBook.get());
    		return optionalBook.get();
    	}else {
    		return null;
    	}
    }
    
    //delete a book
    public void deleteBook(Long id) {
    	Optional<Book> optionalBook = bookRepository.findById(id);
    	if(optionalBook.isPresent()) {
    		bookRepository.deleteById(id);
    	}else {
    		System.out.println("Unable to delete book. Unable to locate book with id: "+id);
    	}
    }
}
