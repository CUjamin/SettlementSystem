package cuj.settlementsystem.repository;

import cuj.settlementsystem.domain.DiscountType;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by cujamin on 2018/1/11.
 */
public class DiscountRepositoryImpl implements DiscountRepository {

    private Map<DiscountType, Double> discountMap = null;

    private void init()
    {
        discountMap = new ConcurrentHashMap<DiscountType, Double>();
        discountMap.put(DiscountType.NEW_BOOK , 1.2);
        discountMap.put(DiscountType.COMMON_BOOK , 1.0);
        discountMap.put(DiscountType.UNSALABLE_BOOK , 0.6);
    }

    /**
     *
     * @return
     */
    public Map<DiscountType, Double> checkAllDiscount() {
        if(discountMap==null)
        {
            init();
        }
        return discountMap;
    }

    /**
     *
     * @param discountType
     * @return
     */
    public double getDiscountByDiscountType(DiscountType discountType) {
        if(discountMap==null)
        {
            init();
        }
        if(discountMap.containsKey(discountType))
            return discountMap.get(discountType);
        return -1;
    }
}
