package junit.b4.bt;

import java.util.Date;

public class Visit {
    private final Customer customer;
    private Date date;
    private double serviceExpense = 0;
    private double productExpense = 0;

    public Visit(Customer customer, Date date) {
        this.customer = customer;
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getServiceExpense() {
        return serviceExpense;
    }

    public void setServiceExpense(double serviceExpense) {
        this.serviceExpense = serviceExpense;
    }

    public double getProductExpense() {
        return productExpense;
    }

    public void setProductExpense(double productExpense) {
        this.productExpense = productExpense;
    }

    public double getTotalExpense() {
        double totalExpense = 0;
        // TH1: là memember
        if (getCustomer().isMember()) {
            String memberType = getCustomer().getMemberType();
            totalExpense = getProductExpense() * (1 - DiscountRate.getProductDiscountRate(memberType)) + getServiceExpense() * (1 - DiscountRate.getServiceDiscountRate(memberType));
            return totalExpense;
        }
        // TH2: không là member
        totalExpense = getProductExpense() + getServiceExpense();
        return totalExpense;
    }

    @Override
    public String toString() {
        return "Visit[" +
                "customer=" + customer +
                ", date=" + date +
                ", serviceExpense=" + serviceExpense +
                ", productExpense=" + productExpense +
                ", totalExpense=" + getTotalExpense() +
                ']';
    }
}
