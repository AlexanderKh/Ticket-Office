package alex;


import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class Flight implements Comparable{
    public static final String DESTINATION = "Destination: ";
    public static final String DATE = "Date: ";
    public static final String SEATS = "Seats: ";
    private City destination;
    private Date date;
    private boolean[] seatsOccupied;

    Flight(City destination, Date date, int maxSeats){
        this.destination = destination;
        this.date = date;
        seatsOccupied = new boolean[maxSeats];
        setRandomSeats();
    }

    private void setRandomSeats(){
        Random rnd = new Random();
        for(int i = 0; i < seatsOccupied.length; i++){
            seatsOccupied[i] = rnd.nextBoolean();
        }
    }

    public boolean hasFreeSeats(int quantity){
        boolean result = false;
        int freeInRow = 0;
        for (int i = 0; i < seatsOccupied.length; i++){
            if (freeInRow == quantity){
                result = true;
                break;
            }
            if (!seatsOccupied[i]){
                freeInRow++;
            } else {
                freeInRow = 0;
            }
        }

        return result;
    }

    public int compareTo(Object o) {
        long result;
        if (o instanceof Flight){
            result = this.date.getTime() - ((Flight) o).date.getTime();
        }else {
            throw new ClassCastException();
        }

        return (int) result;
    }

    @Override
    public String toString(){
        String result = "";
        result += DESTINATION + destination.toString() + "\n";
        result += DATE + date.toString() + "\n";
        result += SEATS + Arrays.toString(seatsOccupied) + "\n";

        return result;
    }
}
