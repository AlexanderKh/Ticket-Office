package alex;


import java.util.Random;

public class Filler {
    public static void fillSeats(Flight flight){
        Random rnd = new Random();
        for (Row row : flight.getRows()){
            for (Seat seat : row.getSeats()){
                seat.setOccupied(rnd.nextBoolean());
            }
        }
    }

}
