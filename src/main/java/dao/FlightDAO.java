package dao;

import entity.Flight;
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
        return sessionFactory.getCurrentSession().createCriteria(Flight.class).list();
    }
}
