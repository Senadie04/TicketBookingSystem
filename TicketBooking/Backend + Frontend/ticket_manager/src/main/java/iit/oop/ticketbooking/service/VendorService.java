package iit.oop.ticketbooking.service;

import iit.oop.ticketbooking.logger.Logger;
import iit.oop.ticketbooking.config.Ticket;
import iit.oop.ticketbooking.config.TicketPool;
import iit.oop.ticketbooking.config.Vendor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class VendorService implements Runnable{
    private TicketPool ticketPool;
    private Vendor vendor;
    private int activeVendors;
    private volatile Boolean programActive = false;
    private static final Logger logger = new Logger();
    private int count = 1;      //this variable is to ensure that the ticket id is unique, and is not repeated.


    public VendorService(TicketPool ticketPool){
        this.ticketPool = ticketPool;
    }

    public void setVendor(Vendor vendor){
        this.vendor = vendor;
    }

    public int getActiveVendors(){
        return activeVendors;
    }

    public void stopProgram(){
        programActive = false;
    }
    public void startProgram(){
        programActive = true;
    }

    @Override
    public void run(){
        if (programActive) {
            activeVendors++;
            for (int i = 1; i <= vendor.getTotalTickets(); i++) {
                Ticket ticket = new Ticket(count, vendor.getEventName(), vendor.getTicketPrice());
                count++;
                ticketPool.addTicket(ticket);


                System.out.println(vendor.getVendorName() + " has added ticket-" + ticket.getTicketID() + " for the "
                        + vendor.getEventName() + " at a price of $" + vendor.getTicketPrice() + ".");

                logger.log(vendor.getVendorName() + " has added ticket-" + ticket.getTicketID() + " for the "
                        + vendor.getEventName() + " at a price of $" + vendor.getTicketPrice() + ".\n");

                try {
                    Thread.sleep(vendor.getTicketReleaseRate() * 1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e.getMessage());
                }
            }
            activeVendors--;
        }else {
            System.out.println("System is not running. Please start the system.");

            logger.log("System is not running. Please start the system.\n");
        }
    }

}
