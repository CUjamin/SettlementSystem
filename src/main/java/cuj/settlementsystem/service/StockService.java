package cuj.settlementsystem.service;

import cuj.settlementsystem.domain.Book;

/**
 * Created by cujamin on 2018/1/12.
 */
public interface StockService {
    void inStock(Book book ,int count);
}
