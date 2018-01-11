package cuj.settlementsystem.repository;

import cuj.settlementsystem.domain.Book;

import java.util.List;

/**
 * Created by cujamin on 2018/1/11.
 */
public interface BookRepository {
    List<Book> checkBookList();

    boolean addNewBook(Book newBook);
    boolean addNewBooks(Book newBook , int number);

    boolean delNewBook(Book newBook);
    boolean delNewBooks(Book newBook , int number);

    Book getTheBookByName(String bookName);
}