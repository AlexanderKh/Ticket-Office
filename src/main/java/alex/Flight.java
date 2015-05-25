package alex;


import java.util.Date;
import java.util.Random;

public class Flight implements Comparable{
    private City destination;
    private Date date;
    private Seat[] seats;

    Flight(City destination, Date date, int maxSeats){
        this.destination = destination;
        this.date = date;
        seats = new Seat[maxSeats];
        for (int i = 0; i < maxSeats; i++) {
            seats[i] = new Seat(this, i + 1);
        }
    }

    public boolean hasFreeSeatsInRow(int quantity){
        boolean result = false;
        int freeInRow = 0;
        for (Seat seat : seats){
            if (freeInRow == quantity){
                result = true;
                break;
            }
            if (!seat.isOccupied()){
                freeInRow++;
            } else {
                freeInRow = 0;
            }
        }

        return result;
    }

    public int compareTo(Object o) {
        if (o instanceof Flight){
            return this.date.compareTo(((Flight) o).date);
        }else {
            throw new ClassCastException();
        }
    }

    public Seat[] getSeats() {
        return seats;
    }

    private static final String DESTINATION = "Destination: ";
    private static final String DATE = "Date: ";
    private static final String SEATS = "Seats: ";
    private static final String NEW_LINE = "\n";

    @Override
    public String toString(){
        String result = "";
        result += DESTINATION + destination.toString() + NEW_LINE;
        result += DATE + date.toString() + NEW_LINE;
        result += SEATS;
        result += NEW_LINE + "-";
        for (Seat seat : seats){
            result += (seat.isOccupied() ? "O" : "F") + "-";
        }
        result += NEW_LINE + NEW_LINE;

        return result;
    }
}
