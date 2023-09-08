public class DiscountRate {
    private final static double serviceDiscountPremium = 0.2;
    private final static double serviceDiscountGold = 0.15;
    private final static double serviceDiscountSilver = 0.1;
    private final static double productDiscountPremium = 0.1;
    private final static double productDiscountGold = 0.1;
    private final static double productDiscountSilver = 0.1;
    private static double productPerchesDiscount;

    public static void setProductPerchesDiscount(double productPerchesDiscount) {
        DiscountRate.productPerchesDiscount = productPerchesDiscount;
    }

    public static double getProductPerchesDiscount() {
        return productPerchesDiscount;
    }

    public static double getServiceDiscountRate(String memberType) {
        return memberType.equalsIgnoreCase("Premium") ? getServiceDiscountPremium() :
                memberType.equalsIgnoreCase("Gold") ? getServiceDiscountGold() : getServiceDiscountSilver();
    }

    public static double getProductDiscountRate(String memberType) {
        return memberType.equalsIgnoreCase("Premium") ? getProductDiscountPremium() :
                memberType.equalsIgnoreCase("Gold") ? getProductDiscountGold() : getProductDiscountSilver();
    }

    public static double getProductDiscountSilver() {
        return productDiscountSilver;
    }

    public static double getServiceDiscountPremium() {
        return serviceDiscountPremium;
    }

    public static double getServiceDiscountGold() {
        return serviceDiscountGold;
    }

    public static double getServiceDiscountSilver() {
        return serviceDiscountSilver;
    }

    public static double getProductDiscountPremium() {
        return productDiscountPremium;
    }

    public static double getProductDiscountGold() {
        return productDiscountGold;
    }
}
