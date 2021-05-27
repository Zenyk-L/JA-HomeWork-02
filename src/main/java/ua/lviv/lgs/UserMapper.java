package ua.lviv.lgs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {

    public static User map(ResultSet result) throws SQLException {
        return  new User(result.getInt("id"),
                result.getString("first_name"),
                result.getString("last_name"),
                result.getString("login"),
                result.getString("password"));
    }
}
