package iit.oop.ticketbooking.config;
import java.math.BigDecimal;

public class Ticket {
    private int ticketID;
    private String eventName;
    private BigDecimal ticketPrice;
//    The constructor for the Ticket class
    public Ticket(int ticketID, String eventName, BigDecimal ticketPrice){
        this.ticketID = ticketID;
        this.eventName = eventName;
        this.ticketPrice = ticketPrice;
    }
//  The getters for the Ticket class
    public int getTicketID() {
        return ticketID;
    }
    public String getEventName(){
        return eventName;
    }
    public BigDecimal getTicketPrice(){
        return ticketPrice;
    }
//  The setters for the Ticket class
    public void setTicketID(int ticketID){
        this.ticketID = ticketID;
    }
    public void setEventName(String eventName){
        this.eventName = eventName;
    }
    public void setTicketPrice(BigDecimal ticketPrice){
        this.ticketPrice = ticketPrice;
    }
}

