package by.autoServiceStation.database.dao.impl;


import by.autoServiceStation.database.ConnectionPool;
import by.autoServiceStation.database.dao.ClientDao;
import by.autoServiceStation.entities.Client;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class ClientDaoImpl implements ClientDao {
    private ResourceBundle queries = ResourceBundle.getBundle("by.autoServiceStation.resources.DatabaseResources");

    @Override
    public boolean addClient(Client client) {
        boolean isSuccess = false;
        try (Connection connection = ConnectionPool.getInstance().getConnection()) {
            PreparedStatement prStatement = connection.prepareStatement(queries.getString("sqlInsertClient"));
            initializePrepareStatement(client, prStatement);
            prStatement.executeUpdate();
            isSuccess = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    @Override
    public Client obtainClient(String firstName, String lastName) {
        List<Client> clients = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getConnection()) {
            PreparedStatement prStatement = connection.prepareStatement(queries.getString("sqLSelectClientByName"));
            prStatement.setString(1, firstName);
            prStatement.setString(2, lastName);
            ResultSet result = prStatement.executeQuery();
            clients = initClients(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients.isEmpty() ? null : clients.get(0);
    }

    @Override
    public List<Client> obtainClients() {
        List<Client> clients = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(queries.getString("sqLSelectClient"));
            clients = initClients(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    private void initializePrepareStatement(Client client, PreparedStatement prStatement) throws SQLException {
        prStatement.setString(1, client.getFirstName());
        prStatement.setString(2, client.getLastName());
        prStatement.setDate(3, convertToSqlDate(client.getDateOfBirth()));
        prStatement.setString(4, client.getAddress());
        prStatement.setString(5, client.getPhone());
        prStatement.setString(6, client.getEmail());
    }

    private Date convertToSqlDate(Calendar calendar) {
        return new Date(calendar.getTime().getTime());
    }

    private List<Client> initClients(ResultSet result) throws SQLException {
        List<Client> clients = new ArrayList<>();
        while (result.next()) {
            Client client = new Client();
            client.setClientId(result.getInt("CLIENT_ID"));
            client.setFirstName(result.getString("FIRST_NAME"));
            client.setLastName(result.getString("LAST_NAME"));
            Calendar dateOfBirth = convertToCalendar(result.getDate("DATE_OF_BIRTH"));
            client.setDateOfBirth(dateOfBirth);
            client.setAddress(result.getString("ADDRESS"));
            client.setPhone(result.getString("PHONE"));
            client.setEmail(result.getString("EMAIL"));
            clients.add(client);
        }
        return clients;
    }

    private Calendar convertToCalendar(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar;
    }
}
