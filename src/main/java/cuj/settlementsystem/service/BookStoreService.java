package cuj.settlementsystem.service;

import cuj.settlementsystem.domain.Book;

import java.util.List;

/**
 * Created by cujamin on 2018/1/11.
 */
public interface BookStoreService {
    List<Book> showBookList();
    float checkPriceByBookName(String bookName);
    String buyBookByName(String bookName , float price);
}
