package alex;


import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class Flight implements Comparable{
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

    private void occupy(int from, int to){
        for (;from <= to; from++){
            seatsOccupied[from] = true;
        }
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
        result += "Destination: " + destination.toString() + "\n";
        result += "Date: " + date.toString() + "\n";
        result += "Seats: " + Arrays.toString(seatsOccupied) + "\n";
        return result;
    }
}
