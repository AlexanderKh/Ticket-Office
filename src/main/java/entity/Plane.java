package entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Plane {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String model;
    private int places;
    @OneToMany
    private List<Flight> flights;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public String toString(){
        return id + " " + model + " " + places;
    }
}
