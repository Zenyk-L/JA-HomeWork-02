package ua.lviv.lgs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static String READ_ALL = "select * from users";
    private static String CREATE = "insert into users(first_name, last_name, login, password) value (?,?,?,?)";
    private static String READ_BY = "select * from users where id = ?";
    private static String UPDATE_BY_ID = "update users set first_name =?, last_name =?, login = ?, password = ? where id =?";
    private static String DELETE_BY_ID = "delete from users where id =?";

    private Connection connection;
    private Statement stmt;
    private PreparedStatement prst;

    public UserDao(Connection connection) {
        this.connection = connection;
    }

    public User read(int id) throws SQLException {
        prst = connection.prepareStatement(READ_BY);
        prst.setInt(1, id);
        ResultSet result = prst.executeQuery();
        result.next();
        return UserMapper.map(result);
    }

    public void insert(User user) throws SQLException {
        prst = connection.prepareStatement(CREATE);
        prst.setString(1, user.getFirstName());
        prst.setString(2, user.getLastName());
        prst.setString(3, user.getLogin());
        prst.setString(4, user.getPassword());
        prst.executeUpdate();
    }

    public void update(User user) throws SQLException {
        prst = connection.prepareStatement(UPDATE_BY_ID);
        prst.setString(1, user.getFirstName());
        prst.setString(2, user.getLastName());
        prst.setString(3, user.getLogin());
        prst.setString(4, user.getPassword());
        prst.setInt(5,user.getId());
        prst.executeUpdate();
    }

    public void delete(int id) throws SQLException {
        prst = connection.prepareStatement(DELETE_BY_ID);
        prst.setInt(1,id);
        prst.executeUpdate();
    }


    public List<User> getAllUser() throws SQLException {
        List<User> userList = new ArrayList<>();
                stmt = connection.createStatement();
        ResultSet result = stmt.executeQuery(READ_ALL);
        while (result.next()){
            userList.add(UserMapper.map(result));
        }
        return userList;
    }


}
