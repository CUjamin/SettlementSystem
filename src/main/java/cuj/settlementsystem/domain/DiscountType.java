package cuj.settlementsystem.domain;

/**
 * Created by cujamin on 2018/1/11.
 */
public enum DiscountType {
    NEW_BOOK("新书"),
    COMMON_BOOK("常规图书"),
    UNSALABLE_BOOK("滞销图书");

    private String type;
    DiscountType(String t)
    {
        this.type = t;
    }

    @Override
    public String toString()
    {
        return String.format("DiscountType { type:%s } ", type);
    }
}
