package by.autoServiceStation.database.dao.impl;

import by.autoServiceStation.database.ConnectionPool;
import by.autoServiceStation.database.dao.AdministratorDao;
import by.autoServiceStation.entities.Administrator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AdministratorDaoImpl implements AdministratorDao {
    private ResourceBundle queries = ResourceBundle.getBundle("by.autoServiceStation.resources.DatabaseResources");

    @Override
    public List<Administrator> obtainAdministrators() {
        List<Administrator> administrators = null;
        try (Connection connection = ConnectionPool.getInstance().getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(queries.getString("sqlSelectAdmins"));
            administrators = initAdmin(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return administrators;
    }
    public List<Administrator> initAdmin(ResultSet result) throws SQLException {
        List<Administrator> administrators = new ArrayList<>();
        while (result.next()) {
            Administrator administrator=new Administrator();
            administrator.setEmail(result.getString("EMAIL"));
            administrator.setPassword(result.getString("PASSWORD"));
            administrators.add(administrator);
        }
        return administrators;
    }
}
