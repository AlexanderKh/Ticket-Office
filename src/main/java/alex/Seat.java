package alex;

public class Seat {
    private boolean isOccupied;
    private Flight flight;
    private int place;

    Seat(Flight flight, int place){
        this.flight = flight;
        this.place = place;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setIsOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    @Override
    public String toString(){
        return String.valueOf(place);
    }
}
