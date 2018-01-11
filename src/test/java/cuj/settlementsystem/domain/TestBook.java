package cuj.settlementsystem.domain;

import org.junit.Test;
import java.util.Date;

/**
 * Created by cujamin on 2018/1/11.
 */
public class TestBook {

    @Test
    public void testBook()
    {
        Book a = new Book("A","author","publish", new Date(),10,DiscountType.NEW_BOOK);
        Book b = new Book("A","author","publish", new Date(),10,DiscountType.NEW_BOOK);
        System.out.println(a.getInfo());
        System.out.println(a.equals(b));
    }
}
