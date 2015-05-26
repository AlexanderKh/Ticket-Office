package alex;


import java.util.*;

public class App {
    public static final String ENTER_CITY_PROPOSITION = "Enter city\nPossible vars are:";
    public static final String ENTER_NUMBER_OF_PASSENGERS_PROPOSITION = "Enter number of passengers: ";
    public static final String NO_ACCEPTABLE_FLIGHTS_FOUND = "No acceptable flights found";
    static String[] citiesList = {
            "London",
            "Paris",
            "Moscow"
    };

    public static void main( String[] args ){
        TicketOffice ticketOffice = new TicketOffice();
        Airport airport = new Airport();
        Random rnd = new Random();
            for (String city : citiesList) {
                airport.addFlight(city, new Date(2015, 06, rnd.nextInt(30)));
                airport.addFlight(city, new Date(2015, 06, rnd.nextInt(30)));
            }


        Scanner in = new Scanner(System.in);
        String ans;
        Flight flight = null;
        while (true) {
            System.out.println("Menu\n1 - show all flights\n2 - get closest flight\n3 - get Ticket for closest flight");
            ans = in.next();
            switch (Integer.valueOf(ans)){
                case (1):
                    System.out.println(airport.printFlights());
                    break;
                case (2):
                    System.out.println(ENTER_CITY_PROPOSITION);
                    System.out.println(Arrays.toString(citiesList));
                    String cityName = in.next();
                    System.out.println(ENTER_NUMBER_OF_PASSENGERS_PROPOSITION);
                    int passengers = in.nextInt();
                    City destination = airport.getCity(cityName);
                    flight = ticketOffice.getClosestFlight(destination, passengers);
                    if (flight != null) {
                        System.out.println(flight);
                    } else {
                        System.out.println(NO_ACCEPTABLE_FLIGHTS_FOUND);
                    }
                    break;
                case (3):
                    System.out.println(flight);
                    int rowNumber, seatNumber;
                    System.out.println("Enter row to buy: ");
                    rowNumber = in.nextInt();
                    System.out.println("Enter place to buy: ");
                    seatNumber = in.nextInt();
                    Seat seat = ticketOffice.buyTicket(flight, rowNumber, seatNumber);
                    if (seat == null)
                        System.out.println("Seat is already taken");
                    else
                        System.out.println("Your seat is:\n" + seat.toString());
                    System.out.println(flight);
            }

        }
    }
}
