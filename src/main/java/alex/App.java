package alex;


import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class App {

    static String[] citiesList = {
            "London",
            "Paris",
            "Moscow",
            "Prague"
    };
    public static void main( String[] args ){
        TicketOffice ticketOffice = new TicketOffice();
        Random rnd = new Random();
        for (int i = 0; i < 3; i++) {
            for (String city : citiesList) {
                ticketOffice.addFlight(city, new Date(2015, 06, rnd.nextInt(30)));
            }
        }
        System.out.println(ticketOffice);
        Scanner in = new Scanner(System.in);
        System.out.println("Enter city \n Possible vars are:\n");
        System.out.println(Arrays.toString(citiesList));
        System.out.println();
        String city = in.next();
        System.out.println("Enter number of passengers: ");
        int passengers = in.nextInt();
        System.out.println();
        Flight flight = ticketOffice.getClosestFlight(city, passengers);
        if (flight != null){
            System.out.println(flight);
        } else {
            System.out.println("No acceptable flights found");
        }
    }
}
