package cuj.settlementsystem.repository;

import cuj.settlementsystem.domain.DiscountType;
import org.apache.log4j.Logger;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by cujamin on 2018/1/11.
 */
public class DiscountRepositoryImpl implements DiscountRepository {

    private final Logger logger = Logger.getLogger(BookRepositoryImpl.class);

    private Map<DiscountType, Double> discountMap = null;

    public DiscountRepositoryImpl()
    {
        init();
    }

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

        return discountMap;
    }

    /**
     *
     * @param discountType
     * @return
     */
    public double getDiscountByDiscountType(DiscountType discountType) {

        if(discountMap.containsKey(discountType))
        {
            double discount = discountMap.get(discountType);
            logger.info(String.format(" [ SUCCES - discountType :%s; discount : %s ] ", discountType, discount));
            return discount;
        }
        else
        {
            logger.info(String.format(" [ ERROR - do not contains this discountType : %s ] ", discountType));
            return 0;
        }
    }
}
