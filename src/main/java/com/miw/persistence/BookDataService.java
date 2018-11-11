package com.miw.persistence;

import java.util.Vector;

import com.miw.model.Book;

public interface BookDataService {
		public Vector<Book> getBooks() throws Exception;

		public Book newBook(Book book) throws Exception;
}
