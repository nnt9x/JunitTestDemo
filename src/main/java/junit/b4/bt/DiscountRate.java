package junit.b4.bt;

import java.util.Locale;

public class DiscountRate {
    private static final double serviceDiscountPremium = 0.2;
    private static final double serviceDiscountGold = 0.15;
    private static final double serviceDiscountSliver = 0.1;

    private static final double productDiscountPremium = 0.1;
    private static final double productDiscountGold = 0.1;
    private static final double productDiscountSliver = 0.1;

    public static double getServiceDiscountRate(String type) {
        if (type == null) {
            return 0;
        }
        switch (type.toUpperCase(Locale.ROOT)) {
            case "PREMIUM":
                return serviceDiscountPremium;
            case "GOLD":
                return serviceDiscountGold;
            case "SLIVER":
                return serviceDiscountSliver;
            default:
                return 0;
        }
    }

    public static double getProductDiscountRate(String type) {
        if (type == null) {
            return 0;
        }
        switch (type.toUpperCase(Locale.ROOT)) {
            case "PREMIUM":
                return productDiscountPremium;
            case "GOLD":
                return productDiscountGold;
            case "SLIVER":
                return productDiscountSliver;
            default:
                return 0;
        }
    }

}
