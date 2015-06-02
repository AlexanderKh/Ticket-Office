import dao.CityDAO;
import dao.FlightDAO;
import dao.PlaneDAO;
import dao.SeatDAO;
import entity.City;
import entity.Flight;
import entity.Plane;
import entity.Seat;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private CityDAO cityDAO;
    @Autowired
    private FlightDAO flightDAO;
    @Autowired
    private PlaneDAO planeDAO;
    @Autowired
    private SeatDAO seatDAO;

    private Scanner in;


    Service(){
        in = new Scanner(System.in);
    }

    public void showAllFlights() {
        List<Flight> flights = flightDAO.getFlights();
        System.out.println(flights.size());
        for (Flight flight : flights){
            System.out.println(flight.toString());
        }
    }

    public void showAllCities(){
        List<City> cities = cityDAO.getCities();
        for (City city : cities){
            System.out.println(city);
        }
    }

    public void addNewFlight() {
        Flight flight = new Flight();

        System.out.println("Select entity.Plane: ");
        flight.setPlane(selectPlane());

        System.out.println("Enter date: ");
        Date date = new Date(0);
        date.setYear(in.nextInt());
        date.setMonth(in.nextInt());
        date.setDate(in.nextInt());
        flight.setDate(date);

        generateSeats(flight);
        randomizeSeats(flight.getSeats());

        System.out.println("Select destination: ");
        flight.setDestination(selectDestination());

        flightDAO.addNewFlight(flight);
    }

    private City selectDestination() {
        System.out.println("List of available cities");
        for (City city : cityDAO.getCities()){
            System.out.println(city);
        }
        System.out.println("Enter id: ");
        return cityDAO.getCity(in.nextInt());
    }

    private Plane selectPlane() {
        System.out.println("List of available planes");
        System.out.println(planeDAO.getPlanes());
        for (Plane plane : planeDAO.getPlanes()){
            System.out.println(plane);
        }
        System.out.println("Enter id: ");
        return planeDAO.getPlane(in.nextInt());
    }

    private void generateSeats(Flight flight){
        List<Seat> seats = new ArrayList<Seat>();
        int maxSeats = flight.getPlane().getPlaces();
        for (int i = 1; i <= maxSeats; i++) {
            Seat seat = new Seat();
            seat.setFlight(flight);
            seat.setPlace(i);
            seat.setOccupied(false);
            seats.add(seat);
        }
        flight.setSeats(seats);
    }

    private void randomizeSeats(List<Seat> seats){
        Random rnd = new Random();
        for (Seat seat : seats){
            seat.setOccupied(rnd.nextBoolean());
        }
    }

    public void reserveSeat() {
        Flight flight = selectFlight();
        System.out.println("Enter seat no to reserve");
        flight.getSeats().get(in.nextInt() - 1).setOccupied(true);
    }

    private Flight selectFlight() {
        System.out.println("List of available flights");
        for (Flight flight : flightDAO.getFlights()){
            System.out.println(flight);
        }
        System.out.println("Enter id: ");
        return flightDAO.getFlight(in.nextInt());
    }

    public void task() {

    }


    public void setCityDAO(CityDAO cityDAO) {
        this.cityDAO = cityDAO;
    }

    public void setFlightDAO(FlightDAO flightDAO) {
        this.flightDAO = flightDAO;
    }

    public void setPlaneDAO(PlaneDAO planeDAO) {
        this.planeDAO = planeDAO;
    }

    public void setSeatDAO(SeatDAO seatDAO) {
        this.seatDAO = seatDAO;
    }
}
