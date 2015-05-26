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

    public Seat buyTicket(Flight flight, int rowNumber, int seatNumber){
        Row row = flight.getRow(rowNumber);
        Seat seat = row.getSeat(seatNumber);
        if (seat.isOccupied())
            return null;
        seat.setOccupied(true);
        return seat;
    }

}
