package alex;


import java.util.LinkedList;
import java.util.List;

public class City {
    private String name;
    private List<Flight> flights;

    City(String name){
        this.name = name;
        flights = new LinkedList<Flight>();
    }

    public void addFlight(Flight flight){
        flights.add(flight);
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return name;
    }

}
