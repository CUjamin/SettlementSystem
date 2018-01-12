package cuj.settlementsystem.repository;

import cuj.settlementsystem.domain.DiscountType;
import org.junit.Before;
import org.junit.Test;
import java.util.Map;


/**
 * Created by cujamin on 2018/1/12.
 */
public class DiscountRepositoryTest {
    DiscountRepository discountRepository = null;
    @Before
    public void setUp() throws Exception {
        discountRepository = new DiscountRepositoryImpl();
    }

    @Test
    public void checkAllDiscount() throws Exception {
        Map<DiscountType,Double> map = discountRepository.checkAllDiscount();
        System.out.println(map.toString());
    }

    @Test
    public void getDiscountByDiscountType() throws Exception {

        System.out.printf("discountType : %s ; discount : %s%n", DiscountType.NEW_BOOK, discountRepository.getDiscountByDiscountType(DiscountType.NEW_BOOK));
        System.out.printf("discountType : %s ; discount : %s%n", DiscountType.COMMON_BOOK, discountRepository.getDiscountByDiscountType(DiscountType.COMMON_BOOK));
        System.out.printf("discountType : %s ; discount : %s%n", DiscountType.UNSALABLE_BOOK, discountRepository.getDiscountByDiscountType(DiscountType.UNSALABLE_BOOK));
    }
}