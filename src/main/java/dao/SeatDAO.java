package dao;

import entity.Flight;
import entity.Seat;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class SeatDAO extends HibernateDaoSupport {
    @Transactional
    public void addNewSeat(Seat seat) {
        getSessionFactory().getCurrentSession().save(seat);
    }

    @Transactional
    public List<Seat> getSeats(Flight flight) {
        return getSessionFactory().getCurrentSession().createCriteria(Seat.class).add(Restrictions.eq("flight", flight)).addOrder(Order.asc("place")).list();
    }

    @Transactional
    public Seat getSeat(Flight flight, int place){
        return (Seat)getSessionFactory().getCurrentSession().createCriteria(Seat.class).add(Restrictions.eq("flight", flight)).add(Restrictions.eq("place", place)).list().get(0);
    }

    @Transactional
    public void update(Seat seat) {
        getSessionFactory().getCurrentSession().update(seat);
    }

    @Transactional
    public List<Seat> ask(String s) {
        return getSessionFactory().getCurrentSession().createSQLQuery(s).list();
    }
}

