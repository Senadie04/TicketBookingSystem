package iit.oop.ticketbooking;

import iit.oop.ticketbooking.logger.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication

public class TicketManagerApplication {
	private static final Logger logger = new Logger();

	public static void main(String[] args) {

		System.out.println("<---Ticket Management System--->\n");
		Scanner scanner = new Scanner(System.in);
		int maximumCapacity = 0;


		// Loop until valid input is provided
		while (true) {
			System.out.print("Enter the maximum ticket capacity for the pool: ");
			try {
				maximumCapacity = scanner.nextInt();
				if (maximumCapacity > 0) { // Check if input is an integer
					break;

				} else {
					System.out.println("The maximum capacity must be a positive integer.");
				}
			}
			catch (Exception e) {
				System.out.println("Invalid input. Please enter an integer.");
				scanner.next();
			}
		}


		// Add the maximum capacity to Spring Boot's context as a property
		System.setProperty("ticket.pool.max.capacity", String.valueOf(maximumCapacity));

		SpringApplication.run(TicketManagerApplication.class, args);
		System.out.println("The application was successfully initialized with a maximum capacity of " + maximumCapacity + " tickets.");
		logger.log("The application was successfully initialized with a maximum capacity of " + maximumCapacity + " tickets.\n");
	}
}