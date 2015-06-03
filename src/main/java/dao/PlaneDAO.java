package dao;

import entity.Plane;

import java.util.List;

public interface PlaneDAO {
    void addPlane(Plane plane);
    void updatePlane(Plane plane);
    void deletePlane(Plane plane);
    List<Plane> getPlanes();
    Plane getPlane(int id);
}
