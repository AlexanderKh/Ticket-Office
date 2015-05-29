package dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class SeatDAO {
    @Autowired
    private SessionFactory sessionFactory;
}
