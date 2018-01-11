package cuj.settlementsystem.repository;

import cuj.settlementsystem.domain.DiscountType;

import java.util.Map;

/**
 * Created by cujamin on 2018/1/11.
 */
public interface DiscountRepository {

    Map<DiscountType, Double> checkAllDiscount();

    double getDiscountByDiscountType(DiscountType discountType);
}
