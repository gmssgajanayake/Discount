import java.util.Date;

public class Visit {

    private final Customer customer;
    private final Date date;
    private double serviceExpenses;
    private double productExpenses;

    public Visit(String name, Date data) {
        customer = new Customer(name);
        this.date = data;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getServiceExpenses() {
        return serviceExpenses;
    }

    public void setServiceExpenses(double serviceExpenses) {
        this.serviceExpenses = serviceExpenses;
    }

    public double getProductExpenses() {
        return productExpenses;
    }

    public void setProductExpenses(double productExpenses) {
        this.productExpenses = productExpenses;
    }

    public double getTotalExpenses() {
        if (customer.isMember()) {
            return Math.round((serviceExpenses * (1 - DiscountRate.getServiceDiscountRate(customer.getMemberType())) +
                    productExpenses * (1 - DiscountRate.getProductDiscountRate(customer.getMemberType()))) * (1 - DiscountRate.getProductPerchesDiscount()) * 10) / 10.0;
        } else {
            return (serviceExpenses + productExpenses) * (1 - DiscountRate.getProductPerchesDiscount());
        }
    }

    private String printSpase(int count) {
        String space = "";
        for (int i = 0; i < 10 - count; i++) {
            space += " ";
        }
        return space + "|";
    }


    @Override
    public String toString() {
        double perchesDiscount = (serviceExpenses + productExpenses - getTotalMemberDiscount()) * DiscountRate.getProductPerchesDiscount();
        return "Date : " + date + " |\n| " + customer.toString() + ("\n|-------------------------------------|") + "\n| Service Expenses    - USD " +
                serviceExpenses + (printSpase(String.valueOf(serviceExpenses).length())) + "\n| Product Expenses    - USD " + productExpenses + ((printSpase(String.valueOf(productExpenses).length()))) +
                (customer.isMember() ? "\n| Membership Discount - USD " + (getTotalMemberDiscount() + printSpase(String.valueOf(getTotalMemberDiscount()).length())) : "") +
                ("\n| Perches Discount    - USD " + perchesDiscount + printSpase(String.valueOf(perchesDiscount).length())) + ("\n|-------------------------------------|") + "\n| Total Expenses      - USD " + getTotalExpenses() + ((printSpase(String.valueOf(getTotalExpenses()).length()))) + ("\n+-------------------------------------+");
    }

    private double getTotalMemberDiscount() {
        double serviceDiscount = serviceExpenses * (customer.getMemberType().equalsIgnoreCase("Premium") ? DiscountRate.getServiceDiscountPremium() : customer.getMemberType().equalsIgnoreCase("Gold") ? DiscountRate.getServiceDiscountGold() : DiscountRate.getServiceDiscountSilver());
        double productDiscount = productExpenses * (customer.getMemberType().equalsIgnoreCase("Premium") ? DiscountRate.getProductDiscountPremium() : customer.getMemberType().equalsIgnoreCase("Gold") ? DiscountRate.getProductDiscountGold() : DiscountRate.getProductDiscountSilver());
        return serviceDiscount + productDiscount;
    }
}
