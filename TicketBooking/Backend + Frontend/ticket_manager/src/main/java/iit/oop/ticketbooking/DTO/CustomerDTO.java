package iit.oop.ticketbooking.DTO;

public class CustomerDTO {
    private String customerName;
    private int customerRetrievalRate;
    private int purchaseQuantity;

    public CustomerDTO(String customerName, int customerRetrievalRate, int purchaseQuantity){
        this.customerName = customerName;
        this.customerRetrievalRate = customerRetrievalRate;
        this.purchaseQuantity = purchaseQuantity;
    }

    public String getCustomerName(){
        return customerName;
    }
    public int getCustomerRetrievalRate(){
        return customerRetrievalRate;
    }
    public int getPurchaseQuantity(){
        return purchaseQuantity;
    }

    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }
    public void setCustomerRetrievalRate(int customerRetrievalRate){
        this.customerRetrievalRate = customerRetrievalRate;
    }
    public void setPurchaseQuantity(int purchaseQuantity){
        this.purchaseQuantity = purchaseQuantity;
    }
}
