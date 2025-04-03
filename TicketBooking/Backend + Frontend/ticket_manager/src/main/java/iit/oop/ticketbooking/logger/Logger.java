package iit.oop.ticketbooking.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    FileWriter file;

    public Logger(){
        try {

            clearLogFile("Ticket Log.txt");

            // Open the file in append mode
            file = new FileWriter("Ticket Log.txt", true);
        } catch (IOException e) {
            System.out.println("An error has occurred while opening the file.");
        }
    }


    public void log(String writeData){

        LocalDateTime dateTime = LocalDateTime.now();
        String timeStamp = dateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss - "));
        try {
            file.write(timeStamp);
            file.write(writeData);
            file.write(System.lineSeparator()); // Ensure a new line is written
            file.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void clearLogFile(String path){
        try (FileWriter writer = new FileWriter(path, false)) {

        }catch (IOException e){
            System.err.println("An error has occurred while clearing the log file");
        }
    }
}
