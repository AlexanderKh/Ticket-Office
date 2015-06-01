package dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class PlaneDAO extends HibernateDaoSupport {
    @Autowired
    private SessionFactory sessionFactory;

}
