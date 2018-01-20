package cuj.settlementsystem.domain;

import java.util.Date;

/**
 * 暂时用书名 bookName 作为图书的唯一表述
 * Created by cujamin on 2018/1/11.
 */
public class Book {

    private String bookName;
    private String author;
    private String publishingHouse;
    private Date publishingDate;
    private double price;
    private String discountTpye;

    public Book() {
    }

    public Book(String bookName, String author, String publishingHouse, Date publishingDate, double price, String discountTpye) {
        this.bookName = bookName;
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.publishingDate = publishingDate;
        this.price = price;
        this.discountTpye = discountTpye;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public Date getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(Date publishingDate) {
        this.publishingDate = publishingDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDiscountTpye() {
        return discountTpye;
    }

    public void setDiscountTpye(String discountTpye) {
        this.discountTpye = discountTpye;
    }

    public String getInfo()
    {
        return "\n------------------------------------------------\n"+
                "-- bookName : " + bookName + " ; \n" +
                "-- author : " + author + " ; \n" +
                "-- publishingHouse : " + publishingHouse + " ; \n" +
                "-- publishingDate : " + publishingDate + " ; \n" +
                "-- price : " + price + " ; \n"+
                "-- discountTpye : " + discountTpye + " ; \n"+
                "------------------------------------------------\n";
    }

    /**
     *
     * 暂时用书名 bookName 作为图书的唯一表述
     * @param other
     * @return
     */
    public boolean equals(Book other)
    {
        if(other==null)return false;
        if(other.bookName==null)return false;
        if(bookName.equals(other.bookName))
        {
            //TODO
            return true;
        }
        return false;
    }
}
