package dao;

import entity.City;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CityDAO extends HibernateDaoSupport {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public List<City> getCities(){
        return getSessionFactory().getCurrentSession().createCriteria(City.class).list();
    }
}
