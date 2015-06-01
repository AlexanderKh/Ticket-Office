package dao;

import entity.Flight;
import entity.Plane;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class FlightDAO extends HibernateDaoSupport {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public List<Flight> getFlights() {
        System.out.println(sessionFactory);
        System.out.println(sessionFactory.getCurrentSession());
        return sessionFactory.getCurrentSession().createCriteria(Flight.class).list();
    }

    @Transactional
    public void addNewFlight(Flight flight) {
        sessionFactory.getCurrentSession().save(flight);
    }

    public Flight getFlight(int i) {
        return (Flight) sessionFactory.getCurrentSession().get(Flight.class, i);
    }
}
