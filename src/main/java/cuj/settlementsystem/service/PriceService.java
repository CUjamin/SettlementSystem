package cuj.settlementsystem.service;

import cuj.settlementsystem.domain.Book;

/**
 * Created by cujamin on 2018/1/11.
 */
public interface PriceService {

    double discountPrice(Book book);
    double discountPrice(double bookPrice , int count,String discountType );

}
