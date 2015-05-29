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

    @Override
    public String toString(){
        return id + " " + destination.toString() + " " + date.toString();
    }
}
