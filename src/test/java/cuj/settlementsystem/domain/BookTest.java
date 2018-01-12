package cuj.settlementsystem.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by cujamin on 2018/1/12.
 */
public class BookTest {
    Book a = null;
    Book b = null;
    @Before
    public void setUp() throws Exception {
        a= new Book("A","author","publish", new Date(),10,DiscountType.NEW_BOOK);
        b = new Book("A","author","publish", new Date(),10,DiscountType.NEW_BOOK);
    }

    @Test
    public void getInfo() throws Exception {
        System.out.println(a.getInfo());
    }

    @Test
    public void equals() throws Exception {
        System.out.println(a.equals(b));
    }

}