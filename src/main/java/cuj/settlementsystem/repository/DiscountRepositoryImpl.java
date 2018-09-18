package cuj.settlementsystem.repository;

import cuj.settlementsystem.domain.DiscountType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by cujamin on 2018/1/11.
 */
public class DiscountRepositoryImpl implements DiscountRepository {

    private final Logger logger = LoggerFactory.getLogger(DiscountRepositoryImpl.class);

    private static DiscountRepository discountRepository = new DiscountRepositoryImpl();

    private Map<String, Double> discountMap = null;

    private DiscountRepositoryImpl() {init();}

    public static DiscountRepository getInstance()
    {
        return discountRepository;
    }

    private void init()
    {
        discountMap = new ConcurrentHashMap<String, Double>();
        discountMap.put(DiscountType.NEW_BOOK , 1.2);
        discountMap.put(DiscountType.COMMON_BOOK , 1.0);
        discountMap.put(DiscountType.UNSALABLE_BOOK , 0.6);
    }

    /**
     *
     * @return
     */
    @Override
    public Map<String, Double> checkAllDiscount() {

        return discountMap;
    }

    /**
     *
     * @param discountType
     * @return
     */
    @Override
    public double getDiscountByDiscountType(String discountType) {

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
