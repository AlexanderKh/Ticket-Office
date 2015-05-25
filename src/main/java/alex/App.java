package alex;


import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class App {

    public static final String ENTER_CITY_PROPOSITION = "Enter city\nPossible vars are:";
    public static final String ENTER_NUMBER_OF_PASSENGERS_PROPOSITION = "Enter number of passengers: ";
    public static final String NO_ACCEPTABLE_FLIGHTS_FOUND = "No acceptable flights found";
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

        while (true) {
            System.out.println(ENTER_CITY_PROPOSITION);
            System.out.println(Arrays.toString(citiesList));

            String city = in.next();
            System.out.println(ENTER_NUMBER_OF_PASSENGERS_PROPOSITION);
            int passengers = in.nextInt();
            Flight flight = ticketOffice.getClosestFlight(city, passengers);
            if (flight != null) {
                System.out.println(flight);
            } else {
                System.out.println(NO_ACCEPTABLE_FLIGHTS_FOUND);
            }
        }
    }
}
