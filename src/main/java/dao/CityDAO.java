package dao;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import entity.City;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CityDAO extends HibernateDaoSupport {
    @Transactional
    public List<City> getCities(){
        return getSessionFactory().getCurrentSession().createCriteria(City.class).list();
    }
    @Transactional
    public City getCity(int i) {
        return (City) getSessionFactory().getCurrentSession().get(City.class, i);
    }
}
