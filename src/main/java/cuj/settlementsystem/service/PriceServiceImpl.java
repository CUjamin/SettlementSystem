package cuj.settlementsystem.service;

import cuj.settlementsystem.domain.Book;
import cuj.settlementsystem.repository.DiscountRepository;
import cuj.settlementsystem.repository.DiscountRepositoryImpl;
import org.apache.log4j.Logger;

/**
 * Created by cujamin on 2018/1/12.
 */
public class PriceServiceImpl implements PriceService {
    private final Logger logger = Logger.getLogger(PriceServiceImpl.class);

    private DiscountRepository discountRepository = new DiscountRepositoryImpl();
    public double discountPrice(Book book) {
        double dicount = discountRepository.getDiscountByDiscountType(book.getDiscountTpye());
        double bookPrice = book.getPrice();
        double price = bookPrice*dicount;
        logger.info(String.format(" book: <%s> bookPrice : %s; the discount :%s; the price :%s", book.getBookName(), bookPrice, dicount, price));
        return price;
    }
}
