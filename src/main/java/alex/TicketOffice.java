package alex;

import java.util.*;

public class TicketOffice {
    private List<Flight> flights;
    private HashMap<String, City> destinations;

    TicketOffice(){
        flights = new LinkedList<Flight>();
        destinations = new HashMap<String, City>();
    }

    public Flight getClosestFlight(String destinationName, int numberOfPassengers){
        Flight result = null;
        City dest = destinations.get(destinationName);
        List<Flight> acceptableFlights = dest.getFlights();
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
        if (!destinations.containsKey(destinationName)){
            addDestination(destinationName);
        }
        City destination = destinations.get(destinationName);
        Flight newFlight = new Flight(destination, date, 10);
        flights.add(newFlight);
        destination.addFlight(newFlight);
    }

    public void addDestination(String name){
        destinations.put(name, new City(name));
    }

    public Set<String> getDestinations(){
        return destinations.keySet();
    }

    public String toString(){
        String result = "Flights list: \n";
        for (Flight flight : flights) {
            result += flight.toString() + "\n";
        }
        return result;
    }
}
