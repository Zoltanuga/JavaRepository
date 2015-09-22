package by.autoServiceStation.service;


import by.autoServiceStation.database.dao.impl.ClientDaoImpl;
import by.autoServiceStation.entities.Client;

import java.util.List;

public class ClientsService {
    private ClientDaoImpl clientDAO = new ClientDaoImpl();

    public boolean addClient(Client client) {
        return clientDAO.addClient(client);
    }

    public Client obtainClient(String firstName, String lastName) {
        return clientDAO.obtainClient(firstName, lastName);
    }

    public List<Client> obtainClients() {
        return clientDAO.obtainClients();
    }
}

