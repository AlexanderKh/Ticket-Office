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

    public Seat reserveSeat(Flight flight, int place){
        Seat result;
        Seat[] seats = flight.getSeats();
        result = seats[place];
        if (result.isOccupied())
            return null;
        result.setIsOccupied(true);

        return result;
    }

    public boolean ReserveFlight(Flight flight, int place){
        return true;
    }
}
