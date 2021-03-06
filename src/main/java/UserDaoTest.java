import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class UserDaoTest {

    // 메인
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DaoFactory.class);

        UserDao userDao = applicationContext.getBean("userDao", UserDao.class);

        User user = new User();
        user.setId("chawon");
        user.setName("김차원");
        user.setPassword("1234");

        userDao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = userDao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());

        System.out.println(user2.getId() + " 조회 성공");
    }
}
