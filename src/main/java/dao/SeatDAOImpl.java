package dao;

import entity.Flight;
import entity.Seat;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class SeatDAOImpl extends HibernateDaoSupport implements SeatDAO {

    private static final String getIndexesOfFreePlaces = "select PLACE, IDS.ID, IDS.FLIGHT_ID, IDS.OCCUPIED from (((( SELECT s1.ID, s1.FLIGHT_ID, s1.PLACE, s1.OCCUPIED from SEAT s2, SEAT s1 WHERE s1.OCCUPIED = FALSE and s1.ID = s2.ID-1 and s2.OCCUPIED = TRUE )) union ((SELECT s1.ID, s1.FLIGHT_ID, s1.PLACE, s1.OCCUPIED from SEAT s1, SEAT s2 WHERE s1.OCCUPIED = FALSE and s1.ID-1 = s2.ID and s2.OCCUPIED = TRUE))) ORDER BY ID) AS IDS INNER JOIN FLIGHT ON IDS.FLIGHT_ID = FLIGHT.ID WHERE FLIGHT_ID = :flightId ORDER BY DATE, PLACE";

    @Transactional
    public void addSeat(Seat seat) {
        getSessionFactory().getCurrentSession().save(seat);
    }

    @Transactional
    public List<Seat> getSeats(){
        Session session = getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Seat.class);
        return criteria.list();
    }

    @Transactional
    public List<Seat> getSeats(Flight flight) {
        Session session = getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Seat.class).add(Restrictions.eq("flight", flight)).addOrder(Order.asc("place"));
        return criteria.list();
    }

    @Transactional
    public Seat getSeat(Flight flight, int place){
        Session session = getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Seat.class).add(Restrictions.eq("flight", flight)).add(Restrictions.eq("place", place));
        return (Seat) criteria.uniqueResult();
    }

    @Transactional
    public void updateSeat(Seat seat) {
        getSessionFactory().getCurrentSession().update(seat);
    }

    @Transactional
    public List<Seat> getIndexesOfFreePlaces(Flight flight) {
        Session session = getSessionFactory().getCurrentSession();
        SQLQuery query = session.createSQLQuery(getIndexesOfFreePlaces);
        query.setParameter("flightId", flight.getId());
        query.addEntity(Seat.class);
        return query.list();
    }

    @Transactional
    public void deleteSeat(Seat seat){
        getSessionFactory().getCurrentSession().delete(seat);
    }
}

