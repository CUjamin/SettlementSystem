package cuj.settlementsystem.repository;

import cuj.settlementsystem.domain.Book;
import org.apache.log4j.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by cujamin on 2018/1/11.
 */
public class BookRepositoryImpl implements BookRepository {

    private final Logger logger = Logger.getLogger(BookRepositoryImpl.class);

    private static BookRepository bookRepository = new BookRepositoryImpl();

    //<bookName,Book> 书目
    private Map<String,Book> bookMap = new ConcurrentHashMap<String, Book>();

    //<bookName,Integer> 库存
    private Map<String,Integer> stockMap = new ConcurrentHashMap<String, Integer>();

    private BookRepositoryImpl() {}

    public static BookRepository getInstance()
    {
        return bookRepository;
    }

    private void updataBookMap(Book newBook)
    {
        //TODO
        bookMap.put(newBook.getBookName() , newBook);
        logger.info(String.format("new book:%s", newBook.getInfo()));
    }

    public Book checkBookInfo(String bookName) {
        if(bookMap.containsKey(bookName))
        {
            return bookMap.get(bookName);
        }
        return null;
    }

    public Map<String, Integer> checkStockMap() {
        return stockMap;
    }

    public boolean addNewBooks(Book newBook, int count) {

        if(count>0)
        {
            int oldCount =0;
            if(stockMap.containsKey(newBook.getBookName()))
            {
                oldCount = stockMap.get(newBook.getBookName());
            }
            else
            {
                updataBookMap(newBook);
            }

            stockMap.put(newBook.getBookName(),oldCount+count);
            logger.info(String.format(" [ SUCCES - the book <%s> old count is %d ; new count is : %d ] ", newBook.getBookName(), oldCount, stockMap.get(newBook.getBookName())));
            return true;
        }
        else
        {
            logger.info(String.format(" [ ERROR - parse number is wrong : %d ] ", count));
            return false;
        }
    }

    public boolean delNewBooks(Book newBook, int count) {
        if(count>0)
        {
            if(stockMap.containsKey(newBook.getBookName()))
            {
                int oldCount = stockMap.get(newBook.getBookName());
                if(oldCount>=count)
                {
                    stockMap.put(newBook.getBookName(),oldCount-count);
                    logger.info(String.format(" [ SUCCES - the book <%s> old count is : %d ; new count is : %d ] ", newBook.getBookName(), oldCount, stockMap.get(newBook.getBookName())));
                    return true;
                }
                else
                {
                    logger.info(String.format(" [ FAILED - the book stock is : %d ; but need count is : %d ] ", oldCount,count));
                    return false;
                }
            }
            else
            {
                logger.info(String.format(" [ FAILED - do not have this book ] "));
                return false;
            }
        }
        else
        {
            logger.info(String.format(" [ ERROR - parse number is wrong : %d ] ", count));
            return false;
        }
    }
}
