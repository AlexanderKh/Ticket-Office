package dao;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import entity.Plane;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class PlaneDAO extends HibernateDaoSupport {

    @Transactional
    public List<Plane> getPlanes(){
        return getSessionFactory().getCurrentSession().createCriteria(Plane.class).list();
    }

    @Transactional
    public Plane getPlane(int i) {
        return (Plane) getSessionFactory().getCurrentSession().get(Plane.class, i);
    }
}
