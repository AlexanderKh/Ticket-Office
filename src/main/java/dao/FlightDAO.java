package dao;


import entity.Flight;

import java.util.List;

public interface FlightDAO {
    void addFlight(Flight flight);
    void updateFlight(Flight flight);
    void deleteFlight(Flight flight);
    List<Flight> getFlights();
    Flight getFlight(int id);
}
