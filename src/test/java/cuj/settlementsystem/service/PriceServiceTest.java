package cuj.settlementsystem.service;

import cuj.settlementsystem.domain.Book;
import cuj.settlementsystem.domain.DiscountType;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by cujamin on 2018/1/12.
 */
public class PriceServiceTest {
    PriceService priceService = null;
    Book bookA = null;
    Book bookB = null;
    Book bookC = null;

    @Before
    public void setUp() throws Exception {
        priceService = new PriceServiceImpl();
        bookA = new Book("A","author","publish", new Date(),10, DiscountType.NEW_BOOK);
        bookB = new Book("B","author","publish", new Date(),10, DiscountType.COMMON_BOOK);
        bookC = new Book("C","author","publish", new Date(),10, DiscountType.UNSALABLE_BOOK);
    }

    @Test
    public void discountPrice() throws Exception {

        System.out.println(priceService.discountPrice(bookA));
        System.out.println(priceService.discountPrice(bookB));
        System.out.println(priceService.discountPrice(bookC));
    }
    @Test
    public void discountPrice1() throws Exception {
        System.out.println(120==priceService.discountPrice(10,10,DiscountType.NEW_BOOK));
        System.out.println(100==priceService.discountPrice(10,10,DiscountType.COMMON_BOOK));
        System.out.println(60==priceService.discountPrice(10,10,DiscountType.UNSALABLE_BOOK));

    }


}