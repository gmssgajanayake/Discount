public class Customer {
    private String name;
    private boolean member;
    private String memberType;

    public Customer(String name) {
        this.name = name;
        member = false;
        memberType = "Not a member";
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        if (memberType.equalsIgnoreCase("Premium") || memberType.equalsIgnoreCase("Gold") || memberType.equalsIgnoreCase("Silver")) {
            this.memberType = memberType;
            setMember(true);
        } else {
            System.out.println("Your entered member type is invalid, The member type should be one of from Premium, Gold, Silver");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMember() {
        return member;
    }

    public void setMember(boolean member) {
        this.member = member;
    }

    private String printSpase(int count) {
        String space = "";
        for (int i = 0; i < 16 - count; i++) {
            space += " ";
        }
        return space + "|";
    }

    @Override
    public String toString() {
        double serviceDiscountRate = memberType.equalsIgnoreCase("Premium") ?
                DiscountRate.getServiceDiscountPremium() : memberType.equalsIgnoreCase("Gold") ?
                DiscountRate.getServiceDiscountGold() : DiscountRate.getServiceDiscountSilver();
        double productDiscountRate = memberType.equalsIgnoreCase("Premium") ?
                DiscountRate.getProductDiscountPremium() : memberType.equalsIgnoreCase("Gold") ?
                DiscountRate.getProductDiscountGold() : DiscountRate.getProductDiscountSilver();

        double perchesRate = DiscountRate.getProductPerchesDiscount();
        return ("Customer Details :                  |\n|\t>> Custom Name  - " + name + (printSpase(name.length())) +
                (member ? ("\n|\t>> Member type  - " + memberType + (printSpase(memberType.length()))) : "")) +
                "\n| Discount Rates :                    |" +
                (member ? ("\n|\t>> Member Rate for" + (printSpase(0)) +
                        ("\n|\t\t   Services - ") + serviceDiscountRate * 100 + " %" + (printSpase(((serviceDiscountRate * 100) + " %").length()))) + ("\n|\t\t   Products - " + productDiscountRate * 100 + " %" + (printSpase(((productDiscountRate * 100) + " %").length()))) : "") +
                ("\n|\t>> Perches Rate - " + (DiscountRate.getProductPerchesDiscount() * 100 + " %") + (printSpase((DiscountRate.getProductPerchesDiscount() * 100 + " %").length())));
    }

}
