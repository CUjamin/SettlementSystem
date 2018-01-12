package cuj.settlementsystem.service;

import cuj.settlementsystem.repository.BookRepository;
import cuj.settlementsystem.repository.BookRepositoryImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cujamin on 2018/1/12.
 */
public class BookStoreServiceTest {
    private BookRepository bookRepository = null;
    private PriceService priceService = null;
    @Before
    public void setUp() throws Exception {
        bookRepository = new BookRepositoryImpl();
        priceService = new PriceServiceImpl();
    }

    @Test
    public void showStockMap() throws Exception {

    }

    @Test
    public void showBookInfo() throws Exception {

    }

    @Test
    public void checkPriceByBookName() throws Exception {

    }

    @Test
    public void buyBookByName() throws Exception {

    }

}