package iit.oop.ticketbooking.config;

import java.math.BigDecimal;

public class Vendor{
    private String vendorName;
    private int totalTickets;
    private int ticketReleaseRate;
    private String eventName;
    private BigDecimal ticketPrice;
//The constructor for the Vendor class
    public Vendor(String vendorName, String eventName, BigDecimal ticketPrice, int totalTickets, int ticketReleaseRate){
        this.vendorName = vendorName;
        this.eventName = eventName;
        this.ticketPrice = ticketPrice;
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
    }

//    Getters for the vendor class
    public String getVendorName(){
        return vendorName;
    }
    public String getEventName(){
        return eventName;
    }
    public BigDecimal getTicketPrice(){
        return ticketPrice;
    }
    public int getTotalTickets(){
        return totalTickets;
    }
    public int getTicketReleaseRate(){
        return ticketReleaseRate;
    }

//    Setters for the vendor class
    public void setVendorName(String vendorName){
        this.vendorName = vendorName;
    }
    public void setEventName(String eventName){
        this.eventName =eventName;
    }
    public void setTicketPrice(BigDecimal ticketPrice){
        this.ticketPrice = ticketPrice;
    }
    public void setTotalTickets(int totalTickets){this.totalTickets = totalTickets;}
    public void setTicketReleaseRate(int ticketReleaseRate){
        this.ticketReleaseRate = ticketReleaseRate;
    }

}
