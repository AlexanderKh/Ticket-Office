package dao;

import entity.Seat;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class SeatDAO extends HibernateDaoSupport {
    @Transactional
    public void addNewSeat(Seat seat) {
        getSessionFactory().getCurrentSession().save(seat);
    }
}
