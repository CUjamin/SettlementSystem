package cuj.settlementsystem.service;

import cuj.settlementsystem.domain.Book;

/**
 * Created by cujamin on 2018/1/11.
 */
public interface BookStoreService {

    void showStockMap();

    void showBookInfo(String bookName);

    double checkPriceByBookName(String bookName);

    Book buyBookByName(String bookName , double price);
}
