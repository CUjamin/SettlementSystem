package cuj.settlementsystem.service;

import cuj.settlementsystem.domain.Book;
import cuj.settlementsystem.domain.DiscountType;
import cuj.settlementsystem.repository.BookRepository;
import cuj.settlementsystem.repository.BookRepositoryImpl;
import org.junit.Test;

import java.util.Date;
import java.util.Map;

/**
 * Created by cujamin on 2018/1/11.
 */
public class TestBookRepository {
    @Test
    public void test()
    {
        BookRepository bookRepository = new BookRepositoryImpl();
        Book bookA = new Book("A","author","publish", new Date(),10, DiscountType.NEW_BOOK);
        Book bookB = new Book("B","author","publish", new Date(),10, DiscountType.NEW_BOOK);
        System.out.printf("addNewBooks:%s%n", bookRepository.addNewBooks(bookA, 5));
        System.out.printf("delNewBooks:%s%n", bookRepository.delNewBooks(bookA, 7));
        System.out.printf("delNewBooks:%s%n", bookRepository.delNewBooks(bookA, 4));
        System.out.printf("delNewBooks:%s%n", bookRepository.delNewBooks(bookB, 4));

        Map<String,Integer> map = bookRepository.checkStockMap();
        for (String key:map.keySet())
        {
            System.out.printf("checkBookByName:%s%n", bookRepository.checkBookInfo(key).getBookName());
        }
    }
}
