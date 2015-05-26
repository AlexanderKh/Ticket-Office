package alex;

public class Seat {
    private boolean occupied;
    private Flight flight;
    private int placeInRow;
    private Row row;

    Seat(Flight flight, Row row, int placeInRow){
        this.flight = flight;
        this.placeInRow = placeInRow;
        this.row = row;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }


    @Override
    public String toString(){
        return String.valueOf(placeInRow);
    }
}
