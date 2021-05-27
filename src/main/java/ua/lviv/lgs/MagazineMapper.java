package ua.lviv.lgs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MagazineMapper {

    public static Magazine map(ResultSet result) throws SQLException {
        return  new Magazine(result.getInt("id"),
                result.getString("name"),
                result.getInt("year"),
                result.getString("month"),
                result.getDouble("price"));
    }
}
