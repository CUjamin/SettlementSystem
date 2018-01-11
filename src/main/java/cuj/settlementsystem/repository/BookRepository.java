package cuj.settlementsystem.repository;

import cuj.settlementsystem.domain.Book;
import java.util.Map;

/**
 * Created by cujamin on 2018/1/11.
 */
public interface BookRepository {

    Book checkBookInfo(String bookName);

    Map<String,Integer> checkStockMap();

    boolean addNewBooks(Book newBook , int count);

    boolean delNewBooks(Book newBook , int count);
}