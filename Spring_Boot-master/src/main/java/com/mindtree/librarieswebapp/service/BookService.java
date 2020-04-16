package com.mindtree.librarieswebapp.service;

import java.util.List;

import com.mindtree.librarieswebapp.entity.Book;

public interface BookService {

	public void saveBook(Book book, long id);

	public List<Book> listAllBook(long id);

	public Book getBook(long id);

	public void updateBook(Book book, long id);

	public void deleteBook(long id);

}
