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
public class BookStoreServiceTest {
    private BookStoreService bookStoreService = null;
    private StockService stockService = null;
    @Before
    public void setUp() throws Exception {
        bookStoreService = new BookStoreServiceImpl();
        stockService = new StockServiceImpl();
        Book bookA = new Book("A","author","publish", new Date(),10, DiscountType.NEW_BOOK);
        stockService.inStock(bookA,10);
    }

    @Test
    public void showStockMap() throws Exception {
        bookStoreService.showStockMap();
    }

    @Test
    public void showBookInfo() throws Exception {
        bookStoreService.showBookInfo("");
        bookStoreService.showBookInfo("A");
    }

    @Test
    public void checkPriceByBookName() throws Exception {
        System.out.println("book <> price :"+bookStoreService.checkPriceByBookName(""));
        System.out.println("book <A> price :"+bookStoreService.checkPriceByBookName("A"));
    }

    @Test
    public void buyBookByName() throws Exception {
        double price = bookStoreService.checkPriceByBookName("A");
        System.out.println("the price is "+price);
        Book book1 = bookStoreService.buyBookByName("A",price);
        System.out.println("buy the book : " +book1);
        Book book2 = bookStoreService.buyBookByName("A",price-1);
        System.out.println("buy the book : " +book2);
        Book book3 = bookStoreService.buyBookByName("A",price+1);
        System.out.println("buy the book : " +book3);
    }

}