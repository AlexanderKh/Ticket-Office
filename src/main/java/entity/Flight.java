package entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Flight {
    @Id
    private int id;
    @ManyToOne
    private City destination;
    private Date date;
    @OneToMany
    private List<Seat> seats;
    @ManyToOne
    private Plane plane;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public City getDestination() {
        return destination;
    }

    public void setDestination(City destination) {
        this.destination = destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    @Override
    public String toString(){
        return id + " " + destination.toString() + " " + date.toString();
    }
}
