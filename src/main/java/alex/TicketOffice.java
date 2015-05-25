package alex;

import java.util.*;

public class TicketOffice {


    public Flight getClosestFlight(City destination, int numberOfPassengers){
        Flight result = null;
        List<Flight> acceptableFlights = destination.getFlights();
        Collections.sort(acceptableFlights);
        for (Flight flight : acceptableFlights)
            if (flight.hasFreeSeatsInRow(numberOfPassengers)) {
                result = flight;
                break;
            }

        return result;
    }
}
