package iit.oop.ticketbooking.DTO;

import java.math.BigDecimal;

public class VendorDTO {
    private String vendorName;
    private int ticketReleaseRate;
    private int totalTickets;
    private String eventName;
    private BigDecimal ticketPrice;

    public VendorDTO(String vendorName, String eventName, BigDecimal ticketPrice, int ticketReleaseRate, int totalTickets){
        this.vendorName = vendorName;
        this.eventName = eventName;
        this.ticketPrice = ticketPrice;
        this.ticketReleaseRate = ticketReleaseRate;
        this.totalTickets = totalTickets;
    }
    public String getVendorName() {
        return vendorName;
    }
    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }
    public int getTotalTickets() {
        return totalTickets;
    }
    public String getEventName() {
        return eventName;
    }
    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }
    public void setTicketReleaseRate(int ticketReleaseRate) {
        this.ticketReleaseRate = ticketReleaseRate;
    }
    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
