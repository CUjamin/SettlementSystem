package cuj.settlementsystem.service;

import cuj.settlementsystem.domain.Book;
import cuj.settlementsystem.repository.DiscountRepository;
import cuj.settlementsystem.repository.DiscountRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by cujamin on 2018/1/12.
 */
public class PriceServiceImpl implements PriceService {

    private final Logger logger = LoggerFactory.getLogger(PriceServiceImpl.class);

    private DiscountRepository discountRepository = DiscountRepositoryImpl.getInstance();

    @Override
    public double discountPrice(Book book) {
        double dicount = discountRepository.getDiscountByDiscountType(book.getDiscountTpye());
        double bookPrice = book.getPrice();
        double price = bookPrice*dicount;
        logger.info(String.format(" book: <%s> bookPrice : %s; the discount :%s; the price :%s", book.getBookName(), bookPrice, dicount, price));
        return price;
    }
    @Override
    public double discountPrice(double bookPrice , int count , String discountType )
    {
        double dicount = discountRepository.getDiscountByDiscountType(discountType);
        double price = bookPrice*dicount*count;
        logger.info(String.format(" book: bookPrice : %s; the discount :%s; the price :%s", bookPrice, dicount, price));
        return price;
    }

}
