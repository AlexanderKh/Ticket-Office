import dao.CityDAO;
import org.springframework.beans.factory.annotation.Autowired;


public class Programme{

    @Autowired
    private CityDAO cityDAO;

    void ex(){
        System.out.println(cityDAO.getCities());
    }

    public void setCityDAO(CityDAO cityDAO) {
        this.cityDAO = cityDAO;
    }

    public CityDAO getCityDAO() {
        return cityDAO;
    }
}
