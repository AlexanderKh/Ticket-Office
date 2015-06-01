import dao.CityDAO;
import dao.FlightDAO;
import dao.PlaneDAO;
import dao.SeatDAO;
import entity.Flight;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class Service {
    @Autowired
    private CityDAO cityDAO;
    @Autowired
    private FlightDAO flightDAO;
    @Autowired
    private PlaneDAO planeDAO;
    @Autowired
    private SeatDAO seatDAO;

    void ex(){

    }

    public void setCityDAO(CityDAO cityDAO) {
        this.cityDAO = cityDAO;
    }

    public void showAllFlights() {
        List<Flight> flights = flightDAO.getFlights();
        for (Flight flight : flights){
            System.out.println(flight);
        }
    }

    public void addNewFlight() {

    }

    public void reserveSeat() {
    }

    public void task() {

    }
}
