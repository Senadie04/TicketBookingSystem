package iit.oop.ticketbooking.config;

public class Customer{
    private String customerName;
    private int customerRetrievalRate;
    private int purchaseQuantity;
//    Constructor for the Customer class
    public Customer(String customerName, int customerRetrievalRate, int purchaseQuantity){
        this.customerName = customerName;
        this.customerRetrievalRate = customerRetrievalRate;
        this.purchaseQuantity = purchaseQuantity;
    }

//    Getters for the Customer class
    public String getCustomerName(){
        return customerName;
    }
    public int getPurchaseQuantity(){
        return purchaseQuantity;
    }
    public int getCustomerRetrievalRate(){
        return customerRetrievalRate;
    }


//    Setters for the Customer class
    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }
    public void setPurchaseQuantity(int purchaseQuantity){
        this.purchaseQuantity = purchaseQuantity;
    }
    public void setCustomerRetrievalRate(int customerRetrievalRate){this.customerRetrievalRate = customerRetrievalRate;}
}