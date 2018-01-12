package cuj.settlementsystem.service;

import cuj.settlementsystem.domain.Book;
import cuj.settlementsystem.repository.BookRepository;
import cuj.settlementsystem.repository.BookRepositoryImpl;
import org.apache.log4j.Logger;
import java.util.Map;

/**
 * Created by cujamin on 2018/1/12.
 */
public class BookStoreServiceImpl implements BookStoreService {

    private final Logger logger = Logger.getLogger(BookRepositoryImpl.class);

    private BookRepository bookRepository = BookRepositoryImpl.getInstance();

    private PriceService priceService = new PriceServiceImpl();

    public void showStockMap() {
        Map<String ,Integer> map = bookRepository.checkStockMap();
        for (String bookName : map.keySet())
            logger.info(String.format(" bookName : %s ; stock : %d ", bookName, map.get(bookName)));
    }

    public void showBookInfo(String bookName) {
        Book book = bookRepository.checkBookInfo(bookName);
        if(book==null)
        {
            logger.info(String.format(" [ ERROR - stockMap is not has the book <%s> ] ", bookName));
        }
        else
        {
            logger.info(" [ SUCCES - showBookInfo : "+book.getInfo()+" ] ");
        }
    }

    public double checkPriceByBookName(String bookName) {
        Book book = bookRepository.checkBookInfo(bookName);
        if(book==null)
        {
            logger.info(String.format(" [ ERROR - stockMap is not has the book <%s> ] ", bookName));
            return 0;
        }
        else
        {
            return priceService.discountPrice(book);
        }
    }

    public Book buyBookByName(String bookName, double price) {
        Book book = bookRepository.checkBookInfo(bookName);
        double needPay = checkPriceByBookName(bookName);
        if(price==needPay)
        {
            if(bookRepository.delNewBooks(book,1))
            {
                logger.info(String.format(" [ SUCCESS - buy the Book: <%s> ] ", bookName));
                return book;
            }
            else
            {
                logger.info(String.format(" [ FAILED - buy the Book: <%s> ] ", bookName));
                return null;
            }
        }
        else
        {
            logger.info(String.format(" [ FAILED - the Book: <%s> need to pay : %s ; but your pay is :%s ] ", bookName, needPay, price));
            return null;
        }
    }
}
