package dao;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import entity.Flight;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class FlightDAO extends HibernateDaoSupport {

    @Transactional
    public List<Flight> getFlights() {
        return getSessionFactory().getCurrentSession().createCriteria(Flight.class).list();
    }

    @Transactional
    public void addNewFlight(Flight flight) {
        getSessionFactory().getCurrentSession().save(flight);
    }

    @Transactional
    public Flight getFlight(int i) {
        return (Flight) getSessionFactory().getCurrentSession().get(Flight.class, i);
    }
}
