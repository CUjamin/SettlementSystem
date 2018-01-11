package cuj.settlementsystem.repository;

import java.util.Map;

/**
 * Created by cujamin on 2018/1/11.
 */
public interface DiscountRepository {
    Map<String,Float> checkAllDiscount();

    boolean addNewDiscount(String discountType,float discount);
    boolean delOldDiscount(String discountType);
    boolean updataDiscount(String discountType,float discount);
    boolean checkDiscountByType(String discountType);

    float getDiscountByDiscountType(String discountType);
}
