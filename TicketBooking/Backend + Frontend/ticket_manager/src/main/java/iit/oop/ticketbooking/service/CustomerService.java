package iit.oop.ticketbooking.service;

import iit.oop.ticketbooking.config.Customer;
import iit.oop.ticketbooking.config.Ticket;
import iit.oop.ticketbooking.config.TicketPool;
import iit.oop.ticketbooking.logger.Logger;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements Runnable{
    private TicketPool ticketPool;
    private Customer customer;
    private int activeCustomers;
    private volatile Boolean programActive = false;
    private static final Logger logger = new Logger();
//    the constructor for the CustomerService class
    public CustomerService(TicketPool ticket){
        this.ticketPool = ticket;
    }
//    the setter for the customer
    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    public int getActiveCustomers(){
        return activeCustomers;
    }
//    the below two methods ensure that the system is stopped or started when the stop or start buttons are pressed.
    public void stopProgram(){
        programActive = false;
    }
    public void startProgram(){
        programActive = true;
    }


    @Override
    public void run(){
        //this if statement ensures that the user has clicked the start button at the beginning of the system.
        if (programActive) {
            activeCustomers++;      //Used for the ticket statuses, to show the no. of active customers.
            for (int i = 0; i < customer.getPurchaseQuantity(); i++) {
//              Calls the buy method.
                Ticket ticket = ticketPool.buyTicket();

                System.out.println(customer.getCustomerName() + " bought a ticket. The ticket is:\n\t" + "Ticket ID: " +
                        ticket.getTicketID() + "\n\tEvent Name: " + ticket.getEventName() + "\n\tTicket Price: " + ticket.getTicketPrice());

//                Text is written in to the log file.
                logger.log(customer.getCustomerName() + " bought a ticket. The ticket is:\n\t" + "Ticket ID: " +
                        ticket.getTicketID() + "\n\tEvent Name: " + ticket.getEventName() + "\n\tTicket Price: " + ticket.getTicketPrice());

                try {
                    Thread.sleep(customer.getCustomerRetrievalRate() * 1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            activeCustomers--;
        }else {
            System.out.println("System is not running. Please start the system.");
            logger.log("System is not running. Please start the system.\n");
        }
    }
}
