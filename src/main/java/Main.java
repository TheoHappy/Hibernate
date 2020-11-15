import Dao.UserDao;
import Entity.User;
import org.hibernate.SessionFactory;
import utils.HibernateSessionFactoryUtil;

public class Main {
    public static void main(String[] args) {


        UserDao userDao = new UserDao();
        User user = new User("Vasile");

        userDao.addUser(user);
//        userDao.getUser(user.getId());
        System.out.println(userDao.getUser(user.getId()));
        userDao.delUser(user.getId());
    }
}
