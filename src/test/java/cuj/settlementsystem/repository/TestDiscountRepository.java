package cuj.settlementsystem.repository;

import cuj.settlementsystem.domain.Book;
import cuj.settlementsystem.domain.DiscountType;
import org.junit.Test;

import java.util.Date;
import java.util.Map;

/**
 * Created by cujamin on 2018/1/11.
 */
public class TestDiscountRepository {
    @Test
    public void test()
    {
        DiscountRepository discountRepository = new DiscountRepositoryImpl();
        Map<DiscountType,Double> map = discountRepository.checkAllDiscount();
        for(DiscountType discountType:map.keySet())
        {
            System.out.printf("%s:%s%n", discountType, discountRepository.getDiscountByDiscountType(discountType));
        }
    }
}
