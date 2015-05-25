package alex;

import java.util.*;

public class TicketOffice {
    public static final String NEW_LINE = "\n";
    public static final String FLIGHTS_LIST = "Flights list:";
    private List<Flight> flights;
    private HashMap<String, City> destinations;

    TicketOffice(){
        flights = new LinkedList<Flight>();
        destinations = new HashMap<String, City>();
    }

    public Flight getClosestFlight(String destinationName, int numberOfPassengers){
        Flight result = null;
        City destinationObject = destinations.get(destinationName.toLowerCase());
        List<Flight> acceptableFlights = destinationObject.getFlights();
        Collections.sort(acceptableFlights);
        for (Flight flight : acceptableFlights){
            if (flight.hasFreeSeats(numberOfPassengers)) {
                result = flight;
                break;
            }
        }

        return result;
    }

    public void addFlight(String destinationName, Date date){
        if (!destinations.containsKey(destinationName.toLowerCase())){
            addDestination(destinationName);
        }
        City destinationObject = destinations.get(destinationName.toLowerCase());
        Flight newFlight = new Flight(destinationObject, date, 10);
        flights.add(newFlight);
        destinationObject.addFlight(newFlight);
    }

    public void addDestination(String name){
        destinations.put(name.toLowerCase(), new City(name));
    }

    public Set<String> getDestinations(){
        return destinations.keySet();
    }

    public String toString(){
        String result = FLIGHTS_LIST + NEW_LINE;
        for (Flight flight : flights) {
            result += flight.toString() + NEW_LINE;
        }

        return result;
    }
}
