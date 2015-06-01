package dao;

import entity.Plane;
import org.h2.table.Plan;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class PlaneDAO extends HibernateDaoSupport {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public List<Plane> getPlanes(){
        return sessionFactory.getCurrentSession().createCriteria(Plane.class).list();
    }

    @Transactional
    public Plane getPlane(int i) {
        return (Plane) sessionFactory.getCurrentSession().get(Plane.class, i);
    }
}
