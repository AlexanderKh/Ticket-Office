package alex;


import java.util.Random;

public class Filler {
    public static void fillSeats(Seat[] seats){
        Random rnd = new Random();
        for (Seat seat : seats){
            seat.setIsOccupied(rnd.nextBoolean());
        }
    }

}
