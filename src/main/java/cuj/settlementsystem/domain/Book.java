package cuj.settlementsystem.domain;

import java.util.Date;

/**
 * Created by cujamin on 2018/1/11.
 */
public class Book {

    private String bookName;
    private String author;
    private String publishingHouse;
    private Date publishingDate;
    private float price;
    private DiscountType discountTpye;

    public Book() {
    }

    /**
     *
     * @param bookName
     * @param author
     * @param publishingHouse
     * @param publishingDate
     * @param price
     * @param discountTpye
     */
    public Book(String bookName, String author, String publishingHouse, Date publishingDate, float price, DiscountType discountTpye) {
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public DiscountType getDiscountTpye() {
        return discountTpye;
    }

    public void setDiscountTpye(DiscountType discountTpye) {
        this.discountTpye = discountTpye;
    }

    public String getInfo()
    {
        return " bookName : " + bookName + " ; \n" +
                " author : " + author + " ; \n" +
                " publishingHouse : " + publishingHouse + " ; \n" +
                " publishingDate : " + publishingDate + " ; \n" +
                " price : " + price + " ; \n"+
                " discountTpye : " + discountTpye + " ; \n";
    }

    /**
     *
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
