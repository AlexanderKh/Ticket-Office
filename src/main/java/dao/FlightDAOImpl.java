package dao;

import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import entity.Flight;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class FlightDAOImpl extends HibernateDaoSupport implements FlightDAO {

    @Transactional
    public List<Flight> getFlights() {
        return getSessionFactory().getCurrentSession().createCriteria(Flight.class).addOrder(Order.asc("date")).list();
    }

    @Transactional
    public void addFlight(Flight flight) {
        getSessionFactory().getCurrentSession().save(flight);
    }

    @Transactional
    public void updateFlight(Flight flight) {
        getSessionFactory().getCurrentSession().update(flight);
    }

    @Transactional
    public void deleteFlight(Flight flight) {
        getSessionFactory().getCurrentSession().delete(flight);
    }

    @Transactional
    public Flight getFlight(int i) {
        return (Flight) getSessionFactory().getCurrentSession().get(Flight.class, i);
    }
}
