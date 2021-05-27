package ua.lviv.lgs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MagazineDao {
    private static String READ_ALL = "select * from magazines";
    private static String CREATE = "insert into magazines (name, year, month, price) value (?,?,?,?)";
    private static String READ_BY = "select * from magazines where id = ?";
    private static String UPDATE_BY_ID = "update magazines set name =?, year =?, month = ?, price = ? where id =?";
    private static String DELETE_BY_ID = "delete from magazines where id =?";

    private Connection connection;
    private Statement stmt;
    private PreparedStatement prst;

    public MagazineDao(Connection connection) {
        this.connection = connection;
    }

    public List<Magazine> readAll() throws SQLException {
        List<Magazine> magazineList = new ArrayList<>();
        stmt = connection.createStatement();
        ResultSet result = stmt.executeQuery(READ_ALL);
        while (result.next()){
            magazineList.add(MagazineMapper.map(result));
        }
        return magazineList;
    }

    public Magazine read(int id) throws SQLException {
        prst = connection.prepareStatement(READ_BY);
        prst.setInt(1,id);
        ResultSet result = prst.executeQuery();
        result.next();
        return  MagazineMapper.map(result);
    }

    public void update(Magazine magazine) throws SQLException {
        prst = connection.prepareStatement(UPDATE_BY_ID);
        prst.setString(1, magazine.getName());
        prst.setInt(2, magazine.getYear());
        prst.setString(3, magazine.getMonth());
        prst.setDouble (4, magazine.getPrice());
        prst.setInt(5, magazine.getId());
        prst.executeUpdate();
    }

    public void insert(Magazine magazine) throws SQLException {
        prst = connection.prepareStatement(CREATE);
        prst.setString(1, magazine.getName());
        prst.setInt(2, magazine.getYear());
        prst.setString(3, magazine.getMonth());
        prst.setDouble(4, magazine.getPrice());
        prst.executeUpdate();
    }

    public void delete(int id) throws SQLException {
        prst = connection.prepareStatement(DELETE_BY_ID);
        prst.setInt(1,id);
        prst.executeUpdate();
    }




}
