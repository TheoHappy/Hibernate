import Dao.UserDao;
import Entity.User;
import org.hibernate.SessionFactory;
import utils.HibernateSessionFactoryUtil;

/**
 * This is my main class, here I wiil test other classes in my project
 * @author Theo
 * @version  1.1
 * @since 1.0
 */
public class Main {
    public static void main(String[] args) {

        /**This is my userDao field*/
        UserDao userDao = new UserDao();
        /** field user*/
        User user = new User();
        /** setUserName for user
         * @see User#setUserName(String)
         * */
        user.setUserName("Vasile");

        /** Add user in user dao
         * @see UserDao#addUser(User)
         * */
        userDao.addUser(user);
        userDao.getUser(user.getId());
        /** getUser by id
         * @see UserDao#getUser(Long)
         * */
        System.out.println(userDao.getUser(user.getId()));
//        userDao.delUser(user.getId());
    }
}
