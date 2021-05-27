package ua.lviv.lgs;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

    UserDao userDao = new UserDao(ConnectionUtils.openConnection());
    MagazineDao magazineDao = new MagazineDao(ConnectionUtils.openConnection());






        userDao.getAllUser().forEach(System.out::println);
        System.out.println("=============================================================================");

//        userDao.insert(new User("nine" , "nine", "ninenine", "nine"));

        userDao.update(new User(1,"One" , "One", "OneOneee", "*-*-*-*-*-*"));

        System.out.println(userDao.read(1));
        System.out.println("=============================================================================");

        userDao.delete(7);


        userDao.getAllUser().forEach(System.out::println);
        System.out.println("=============================================================================");

        magazineDao.readAll().forEach(System.out::println);

        Magazine magazineGeted = magazineDao.read(1);
        System.out.println(magazineGeted);
        System.out.println("=============================================================================");

        magazineGeted.setPrice(magazineGeted.getPrice() + 10);
        magazineDao.update(magazineGeted);
        System.out.println(magazineGeted);
        System.out.println("=============================================================================");

        magazineDao.readAll().forEach(System.out::println);
        System.out.println("=============================================================================");
        magazineDao.insert(new Magazine("Traveler",2019,"September", 10.0));
        magazineDao.readAll().forEach(System.out::println);
        System.out.println("=============================================================================");

        magazineDao.delete(2);
        magazineDao.readAll().forEach(System.out::println);
        System.out.println("=============================================================================");

    }
}
