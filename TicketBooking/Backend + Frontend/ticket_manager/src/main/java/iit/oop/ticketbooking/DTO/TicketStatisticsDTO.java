package iit.oop.ticketbooking.DTO;

public class TicketStatisticsDTO {
    private int ticketPoolSize;
    private int activeVendors;
    private int activeCustomers;
    private int totalSales;

    public TicketStatisticsDTO(int ticketPoolSize, int activeVendors, int activeCustomers, int totalSales){
        this.ticketPoolSize = ticketPoolSize;
        this.activeVendors = activeVendors;
        this.activeCustomers = activeCustomers;
        this.totalSales = totalSales;
    }

//    getters for the statistic data.
    public int getTicketPoolSize(){
        return ticketPoolSize;
    }
    public int getActiveVendors(){
        return activeVendors;
    }
    public int getActiveCustomers(){
        return activeCustomers;
    }
    public int getTotalSales(){
        return totalSales;
    }

//    setters for the statistic data
    public void setTicketPoolSize(int ticketPoolSize){
        this.ticketPoolSize = ticketPoolSize;
    }
    public void setActiveVendors(int activeVendors){
        this.activeVendors = activeVendors;
    }
    public void setActiveCustomers(int activeCustomers){
        this.activeCustomers = activeCustomers;
    }
    public void setTotalSales(int totalSales){
        this.totalSales = totalSales;
    }
}
