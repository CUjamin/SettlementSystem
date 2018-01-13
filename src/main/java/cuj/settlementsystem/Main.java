package cuj.settlementsystem;


import cuj.settlementsystem.domain.DiscountType;
import cuj.settlementsystem.service.PriceService;
import cuj.settlementsystem.service.PriceServiceImpl;
import java.util.Scanner;

/**
 * Created by cujamin on 2018/1/11.
 */
public class Main {
    public static void main(String[] args) {
        PriceService priceService = new PriceServiceImpl();
        boolean flag = true;
        double sumPrice = 0;

        Scanner input = new Scanner(System.in);
        System.out.println("开始购书");
        while(flag)
        {
            String type = "";
            System.out.print("请输入需要购买图书的种类：新书\\常规图书\\滞销图书: ");
            while(true)
            {
                type = input.next().trim();
                if(type.equals(DiscountType.NEW_BOOK)||type.equals(DiscountType.COMMON_BOOK)||type.equals(DiscountType.UNSALABLE_BOOK))
                {
                    break;
                }
                else
                {
                    System.out.println("图书类型错误 :"+type);
                    System.out.print("请重新输入需要购买图书的种类：新书\\常规图书\\滞销图书: ");
                }
            }

            double bookPrice = 0;
            System.out.print("请输入图书价格：");
            while (true)
            {
                bookPrice = input.nextDouble();
                if (bookPrice>0)
                {
                    break;
                }
                else
                {
                    System.out.println("图书价格错误 price："+bookPrice);
                    System.out.print("请重新输入图书价格：");
                }

            }

            int count = 0;
            System.out.print("请输入购买图书数量：");
            while (true)
            {
                count = input.nextInt();
                if(count>0)
                {
                    break;
                }
                else
                {
                    System.out.println("数量错误 count："+count);
                    System.out.print("请重新输入购买图书数量：");

                }
            }

            sumPrice += priceService.discountPrice(bookPrice,count,type);

            System.out.println("目前总价："+sumPrice);
            System.out.println("书否继续购书：Y/N");
            String answer = input.next().trim();
            if(answer.equals("Y"))
            {
                System.out.println("继续购买");
                continue;
            }
            else
            {
                System.out.println("完成购买");
                break;
            }
        }
        System.out.println("结算，总价："+sumPrice);
    }
}
