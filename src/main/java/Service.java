import dao.CityDAOImpl;
import dao.FlightDAOImpl;
import dao.PlaneDAOImpl;
import dao.SeatDAOImpl;
import entity.City;
import entity.Flight;
import entity.Plane;
import entity.Seat;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.*;

public class Service {
    @Autowired
    private CityDAOImpl cityDAO;
    @Autowired
    private FlightDAOImpl flightDAO;
    @Autowired
    private PlaneDAOImpl planeDAO;
    @Autowired
    private SeatDAOImpl seatDAO;

    private Scanner in;


    Service(){
        in = new Scanner(System.in);
    }

    public void showAllFlights() {
        List<Flight> flights = flightDAO.getFlights();
        System.out.println(flights.size());
        for (Flight flight : flights){
            System.out.println(flight.toString());
            for (Seat seat : seatDAO.getSeats(flight)){
                System.out.print(seat);
            }
            System.out.println();
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

        System.out.println("Select destination: ");
        flight.setDestination(selectDestination());

        flightDAO.addNewFlight(flight);

        generateSeats(flight);
        randomizeSeats(flight.getSeats());
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
            seatDAO.addNewSeat(seat);
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
        Seat seat = seatDAO.getSeat(flight, in.nextInt());
        seat.setOccupied(true);
        seatDAO.updateSeat(seat);
    }

    private Flight selectFlight() {
        System.out.println("List of available flights");
        for (Flight flight : flightDAO.getFlights()){
            System.out.println(flight);
        }
        System.out.println("Enter id: ");
        return flightDAO.getFlight(in.nextInt());
    }

    public Flight getClosestFlightWithFreePlaces(int placesToFind) {
        System.out.println("Enter places to find: ");
        int needInRow = in.nextInt();
        List<Flight> flights = flightDAO.getFlights();
        Flight acceptable = null;
        b: for (Flight flight : flights){
            List<Seat> seats = new ArrayList<Seat>();
            seats.add(new Seat(-1, 1, false, flight));
            seats.addAll(seatDAO.getIndexesOfFreePlaces(flight));
            seats.add(new Seat(Integer.MAX_VALUE, flight.getPlane().getPlaces(), false, flight));
            for (Iterator<Seat> iterator = seats.iterator(); iterator.hasNext(); ){
                Seat prev = iterator.next();
                Seat next = iterator.next();
                if (next.getPlace() - prev.getPlace() >= needInRow){
                    acceptable = flight;
                    break b;
                }
            }
        }
        System.out.println(acceptable);
    }


    public void setCityDAO(CityDAOImpl cityDAO) {
        this.cityDAO = cityDAO;
    }

    public void setFlightDAO(FlightDAOImpl flightDAO) {
        this.flightDAO = flightDAO;
    }

    public void setPlaneDAO(PlaneDAOImpl planeDAO) {
        this.planeDAO = planeDAO;
    }

    public void setSeatDAO(SeatDAOImpl seatDAO) {
        this.seatDAO = seatDAO;
    }
}
