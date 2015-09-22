package by.autoServiceStation.database.dao;


import by.autoServiceStation.entities.Client;

import java.util.List;

public interface ClientDao {
    boolean addClient(Client client);
    Client obtainClient(String firstName, String lastName);
    List<Client> obtainClients();
}
