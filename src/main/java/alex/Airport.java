package alex;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Airport {
    private List<Flight> flights = new LinkedList<Flight>();
    private HashMap<String, City> destinations = new HashMap<String, City>();

    public void addFlight(String destinationName, Date date){
        if (!destinations.containsKey(destinationName.toLowerCase())){
            addDestination(destinationName);
        }
        City destinationObject = getCity(destinationName);
        Flight newFlight = new Flight(destinationObject, date, 3, 6);
        Filler.fillSeats(newFlight);
        flights.add(newFlight);
        destinationObject.addFlight(newFlight);
    }

    public City getCity(String key) {
        return destinations.get(key.toLowerCase());
    }

    public void addDestination(String name){
        destinations.put(name.toLowerCase(), new City(name));
    }

    public String printFlights(){
        String result = "";
        for (Flight flight : flights){
            result += flight.toString();
        }
        return result;
    }

}
