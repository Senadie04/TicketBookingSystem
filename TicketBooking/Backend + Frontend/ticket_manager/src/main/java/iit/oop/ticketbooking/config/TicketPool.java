package iit.oop.ticketbooking.config;

import iit.oop.ticketbooking.logger.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Queue;

@Component
public class TicketPool {
    private Queue<Ticket> ticketQueue;
    private int maxCapacity;
    private int totalSales = 0;
    private static final Logger logger = new Logger();

    public TicketPool(@Value("${ticket.pool.max.capacity}") int maxCapacity){
        this.maxCapacity = maxCapacity;
        this.ticketQueue = new LinkedList<>();
    }

    public synchronized void addTicket(Ticket ticket){
        while (ticketQueue.size() >= maxCapacity){
            try {
                logger.log("The pool is full. Waiting for customers to buy tickets.");
                System.out.println("The pool is full. Waiting for customers to buy tickets.");
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
                logger.log("An error has occurred while waiting for customers to buy tickets.");
                System.out.println("An error has occurred while waiting for customers to buy tickets.");
                throw new RuntimeException(e.getMessage());
            }
        }

        this.ticketQueue.add(ticket);
        notifyAll();
    }

    public synchronized Ticket buyTicket(){
        while (ticketQueue.isEmpty()){
            try {
                logger.log("The pool is currently empty. Waiting for tickets to be added.");
                System.out.println("The pool is currently empty. Waiting for tickets to be added.");
                wait();
            }catch (InterruptedException e){
                logger.log("An error has occurred while waiting for tickets to be released.");
                System.out.println("An error has occurred while waiting for tickets to be released.");
                throw new RuntimeException(e.getMessage());
            }
        }

        Ticket ticket = ticketQueue.poll();
        totalSales++;
        notifyAll();

        return ticket;
    }

    public int getTicketPoolSize(){
        return ticketQueue.size();
    }

    public int getTotalSales(){
        return totalSales;
    }
}
