package cuj.settlementsystem.service;

import cuj.settlementsystem.domain.Book;
import cuj.settlementsystem.domain.DiscountType;
import cuj.settlementsystem.repository.BookRepository;
import cuj.settlementsystem.repository.BookRepositoryImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by cujamin on 2018/1/12.
 */
public class StockServiceTest {

    private BookRepository bookRepository = null;
    @Before
    public void setUp() throws Exception {
        bookRepository = BookRepositoryImpl.getInstance();
    }

    @Test
    public void inStock() throws Exception {
        Book bookA = new Book("A","author","publish", new Date(),10, DiscountType.NEW_BOOK);
        bookRepository.addNewBooks(bookA,10);
        bookRepository.addNewBooks(bookA,0);
    }

}