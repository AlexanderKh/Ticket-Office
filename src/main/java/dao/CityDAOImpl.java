package dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import entity.City;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CityDAOImpl extends HibernateDaoSupport implements CityDAO {

    @Transactional
    public List<City> getCities(){
        Session session = getSessionFactory().getCurrentSession();
        return session.createCriteria(City.class).list();
    }
    @Transactional
    public City getCity(int id) {
        return (City) getSessionFactory().getCurrentSession().get(City.class, id);
    }

    @Transactional
    public City getCity(String name) {
        Session session = getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(City.class).add(Restrictions.eq("name", name));
        return (City) criteria.uniqueResult();
    }

    @Transactional
    public void deleteCity(City city) {
        getSessionFactory().getCurrentSession().delete(city);
    }

    @Transactional
    public void updateCity(City city) {
        getSessionFactory().getCurrentSession().update(city);
    }

    @Transactional
    public void addCity(City city) {
        getSessionFactory().getCurrentSession().save(city);
    }
}
