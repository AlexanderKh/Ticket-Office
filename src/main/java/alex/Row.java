package alex;

public class Row {
    private Seat[] seats;
    private Flight flight;
    private int rowNumber;

    Row(Flight flight, int rowNumber){
        this.rowNumber = rowNumber;
        this.flight = flight;
        int maxSeats = flight.getMaxSeatsInRow();
        this.seats = new Seat[maxSeats];
        for (int i = 0; i < maxSeats; i++) {
            seats[i] = new Seat(flight, this, i + 1);
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

    public Seat[] getSeats() {
        return seats;
    }

    public Seat getSeat(int seatNumber){
        return seats[seatNumber - 1];
    }

    public Flight getFlight() {
        return flight;
    }

    public String toString(){
        String result = "";
        for (Seat seat : seats){
            result += (seat.isOccupied()) ? "O" : "_";
        }
        return result;
    }
}
