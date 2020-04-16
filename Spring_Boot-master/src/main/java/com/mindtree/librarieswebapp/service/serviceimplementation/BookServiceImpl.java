package com.mindtree.librarieswebapp.service.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.librarieswebapp.entity.Book;
import com.mindtree.librarieswebapp.entity.Library;
import com.mindtree.librarieswebapp.repository.BookRepository;
import com.mindtree.librarieswebapp.repository.LibraryRepository;
import com.mindtree.librarieswebapp.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private LibraryRepository libraryRepository;

	public void saveBook(Book book, long id) {
		Library library = libraryRepository.findById(id).get();
		book.setLibrary(library);
		library.getBooksList().add(book);
		bookRepository.save(book);
	}

	public List<Book> listAllBook(long id) {
		Library library = libraryRepository.findById(id).get();
		List<Book> books = library.getBooksList();
		return books;
	}

	public Book getBook(long id) {
		return bookRepository.findById(id).get();
	}

	public void updateBook(Book book, long id) {
		Book book2 = bookRepository.findById(id).get();
		book2.setBookName(book.getBookName());

		bookRepository.save(book2);
	}

	public void deleteBook(long id) {
		bookRepository.deleteById(id);
	}
}
