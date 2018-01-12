package cuj.settlementsystem.repository;

import cuj.settlementsystem.domain.Book;
import cuj.settlementsystem.domain.DiscountType;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by cujamin on 2018/1/12.
 */
public class BookRepositoryTest {

    BookRepository bookRepository =null;
    Book bookA = null;
    Book bookB = null;

    @Before
    public void setUp() throws Exception {
        bookRepository = BookRepositoryImpl.getInstance();
        bookA = new Book("A","author","publish", new Date(),10, DiscountType.NEW_BOOK);
        bookB = new Book("B","author","publish", new Date(),10, DiscountType.NEW_BOOK);
        bookRepository.addNewBooks(bookA, 1);
        bookRepository.addNewBooks(bookB, 1);
    }

    @Test
    public void checkBookInfo() throws Exception {
        Book book = bookRepository.checkBookInfo("A");
        checkBook("A",book);
        book = bookRepository.checkBookInfo("C");
        checkBook("C",book);
    }
    private void checkBook(String bookName,Book book)
    {
        if(book==null)
        {
            System.out.printf(String.format("BOOK <%s> is null\n", bookName));
        }
        else
        {
            System.out.printf(String.format("BOOK <%s>:%s\n", bookName, book.getInfo()));
        }
    }

    @Test
    public void checkStockMap() throws Exception {

        Map<String,Integer> map = bookRepository.checkStockMap();
        for (String bookName:map.keySet())
        {
            System.out.printf("checkBookByName:%s ; stock :%d %n", bookName ,map.get(bookName));
        }
    }

    @Test
    public void addNewBooks() throws Exception {

        System.out.printf("addNewBooks:%s%n", bookRepository.addNewBooks(bookA, -1));
        System.out.printf("addNewBooks:%s%n", bookRepository.addNewBooks(bookA, 0));
        System.out.printf("addNewBooks:%s%n", bookRepository.addNewBooks(bookA, 5));
    }

    @Test
    public void delNewBooks() throws Exception {

        System.out.printf("delNewBooks:%s%n", bookRepository.delNewBooks(bookA, -1));
        System.out.printf("delNewBooks:%s%n", bookRepository.delNewBooks(bookA, 0));
        System.out.printf("delNewBooks:%s%n", bookRepository.delNewBooks(bookA, 7));
        System.out.printf("delNewBooks:%s%n", bookRepository.delNewBooks(bookA, 4));
        System.out.printf("delNewBooks:%s%n", bookRepository.delNewBooks(bookB, 4));
    }

}