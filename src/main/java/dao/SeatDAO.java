package dao;

import entity.Flight;
import entity.Seat;

import java.util.List;

public interface SeatDAO {
    void addSeat(Seat seat);
    List<Seat> getSeats();
    List<Seat> getSeats(Flight flight);
    Seat getSeat(Flight flight, int place);
    void updateSeat(Seat seat);
    List<Seat> getIndexesOfFreePlaces(Flight flight);
    void deleteSeat(Seat seat);
}
