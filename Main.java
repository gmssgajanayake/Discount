import java.util.Date;

public class Main {
    public static void main(String[] args) {
        DiscountRate.setProductPerchesDiscount(0.1);
        Visit visit = new Visit("Nimal", new Date());
        printBill(visit);

        System.out.println();
        System.out.println();


        visit.setProductExpenses(673.34);
        visit.setServiceExpenses(287.96);
        printBill(visit);

        System.out.println();
        System.out.println();

        visit.getCustomer().setMemberType("Premium");
        printBill(visit);

    }

    public static void printBill(Visit visit) {
        System.out.println("+-------------------------------------+");
        System.out.println("|             Salon Bill              |");
        System.out.println("+-------------------------------------+");
        System.out.println("| " + visit.toString());

    }
}