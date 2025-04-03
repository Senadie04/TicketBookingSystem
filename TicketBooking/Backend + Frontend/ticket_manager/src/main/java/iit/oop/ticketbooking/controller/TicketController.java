package iit.oop.ticketbooking.controller;

import iit.oop.ticketbooking.config.Customer;
import iit.oop.ticketbooking.DTO.CustomerDTO;
import iit.oop.ticketbooking.DTO.TicketStatisticsDTO;
import iit.oop.ticketbooking.DTO.VendorDTO;
import iit.oop.ticketbooking.logger.Logger;
import iit.oop.ticketbooking.config.TicketPool;
import iit.oop.ticketbooking.config.Vendor;
import iit.oop.ticketbooking.service.CustomerService;
import iit.oop.ticketbooking.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.math.BigDecimal;
import java.util.stream.Collectors;
import java.io.FileReader;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    private final CustomerService customerService;
    private final VendorService vendorService;
    private final TicketPool ticketPool;
    private static final Logger logger = new Logger();


    @Autowired
    public TicketController(CustomerService customerService, VendorService vendorService, TicketPool ticketPool){
        this.customerService = customerService;
        this.vendorService = vendorService;
        this.ticketPool = ticketPool;
    }

    @GetMapping("/statistics")
    public ResponseEntity<TicketStatisticsDTO> getTicketStat(){
        int ticketPoolSize = ticketPool.getTicketPoolSize();
        int totalSales = ticketPool.getTotalSales();
        int activeVendors = vendorService.getActiveVendors();
        int activeCustomers = customerService.getActiveCustomers();

        TicketStatisticsDTO ticketStatisticsDTO = new TicketStatisticsDTO(ticketPoolSize, activeVendors, activeCustomers, totalSales);

        return ResponseEntity.ok(ticketStatisticsDTO);
    }

    @PostMapping("/customers")
    public ResponseEntity<?> createCustomer(
        @RequestParam String customerName,
        @RequestParam int customerRetrievalRate,
        @RequestParam int purchaseQuantity
    ){
        Customer customer = new Customer(customerName, customerRetrievalRate, purchaseQuantity);

        customerService.setCustomer(customer);
        new Thread(customerService).start();

        return ResponseEntity.ok(new CustomerDTO(customerName, customerRetrievalRate, purchaseQuantity));
    }

    @PostMapping("/vendors")
    public ResponseEntity<?> createVendor(
            @RequestParam String vendorName,
            @RequestParam String eventName,
            @RequestParam BigDecimal ticketPrice,
            @RequestParam int totalTickets,
            @RequestParam int ticketReleaseRate
    ){
        Vendor vendor = new Vendor(vendorName, eventName, ticketPrice, totalTickets, ticketReleaseRate);

        vendorService.setVendor(vendor);
        new Thread(vendorService).start();

        return ResponseEntity.ok(new VendorDTO(vendorName, eventName, ticketPrice, totalTickets, ticketReleaseRate));
    }

    @GetMapping("/logs")
    private ResponseEntity<String> getLogs(){
        String fileData = readFile();
        return ResponseEntity.ok(fileData);
    }

    @PostMapping("/stop")
    public ResponseEntity<?> stopProgram(){
        customerService.stopProgram();
        vendorService.stopProgram();
        System.out.println("System has stopped successfully.");
        logger.log("System stopped.\n");

        return ResponseEntity.ok("System stopped.");
    }

    @PostMapping("/start")
    public ResponseEntity<?> startProgram(){
        customerService.startProgram();
        vendorService.startProgram();

        System.out.println("System started.");
        logger.log("System started.\n");

        return ResponseEntity.ok("System started.");
    }

    private String  readFile(){
        StringBuilder log = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("ticket Log.txt"))) {
            log.append(reader.lines().collect(Collectors.joining("\n")));
        }catch (IOException e){
            return "Error reading the file";
        }
        return log.toString();
    }


}
