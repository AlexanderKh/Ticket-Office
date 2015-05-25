package alex;


import java.util.*;

public class App {

    public static final String NEW_LINE = "\n";
    public static final String FLIGHTS_LIST = "Flights list:";


    public static final String ENTER_CITY_PROPOSITION = "Enter city\nPossible vars are:";
    public static final String ENTER_NUMBER_OF_PASSENGERS_PROPOSITION = "Enter number of passengers: ";
    public static final String NO_ACCEPTABLE_FLIGHTS_FOUND = "No acceptable flights found";
    static String[] citiesList = {
            "London",
            "Paris",
            "Moscow",
            "Prague"
    };

    public static List<Flight> flights = new LinkedList<Flight>();
    public static HashMap<String, City> destinations = new HashMap<String, City>();



    public static void addFlight(String destinationName, Date date){
        if (!destinations.containsKey(destinationName.toLowerCase())){
            addDestination(destinationName);
        }
        City destinationObject = getCity(destinationName);
        Flight newFlight = new Flight(destinationObject, date, 10);
        Filler.fillSeats(newFlight.getSeats());
        flights.add(newFlight);
        destinationObject.addFlight(newFlight);
    }

    private static City getCity(String key) {
        return destinations.get(key.toLowerCase());
    }

    public static void addDestination(String name){
        destinations.put(name.toLowerCase(), new City(name));
    }

    public static void main( String[] args ){
        TicketOffice ticketOffice = new TicketOffice();
        Random rnd = new Random();
            for (String city : citiesList) {
                addFlight(city, new Date(2015, 06, rnd.nextInt(30)));
                addFlight(city, new Date(2015, 06, rnd.nextInt(30)));
                addFlight(city, new Date(2015, 06, rnd.nextInt(30)));
            }

        System.out.println(flights.toString());
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println(ENTER_CITY_PROPOSITION);
            System.out.println(Arrays.toString(citiesList));

            String city = in.next();
            System.out.println(ENTER_NUMBER_OF_PASSENGERS_PROPOSITION);
            int passengers = in.nextInt();
            Flight flight = ticketOffice.getClosestFlight(getCity(city), passengers);
            if (flight != null) {
                System.out.println(flight);
            } else {
                System.out.println(NO_ACCEPTABLE_FLIGHTS_FOUND);
            }
        }
    }
}
