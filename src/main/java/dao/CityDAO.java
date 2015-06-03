package dao;

import entity.City;

import java.util.List;

public interface CityDAO {
    List<City> getCities();
    City getCity(int id);
    City getCity(String name);
    void deleteCity(City city);
    void updateCity(City city);
    void addCity(City city);
}
