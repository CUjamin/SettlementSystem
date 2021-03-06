package cuj.settlementsystem.service;

import cuj.settlementsystem.domain.Book;
import cuj.settlementsystem.repository.BookRepository;
import cuj.settlementsystem.repository.BookRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by cujamin on 2018/1/12.
 */
public class StockServiceImpl implements StockService {
    private final Logger logger = LoggerFactory.getLogger(StockServiceImpl.class);
    private BookRepository bookRepository = BookRepositoryImpl.getInstance();
    @Override
    public void inStock(Book book , int count) {
        boolean result = bookRepository.addNewBooks(book,count);
        logger.info(String.format(" [ inStock New book <%s> ; count :%d ; result : %s] ", book.getBookName(), count, result));
    }
}
