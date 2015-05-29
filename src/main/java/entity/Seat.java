package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Seat implements Comparable {
    @Id
    private int id;
    private boolean occupied;
    private int place;
    @ManyToOne
    private Flight flight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public int compareTo(Object o) {
        if (o instanceof Seat){
            return this.place - ((Seat) o).place;
        } else {
            throw new ClassCastException();
        }
    }

    @Override
    public String toString(){
        return flight + "\n" + place + " " + occupied;
    }
}
