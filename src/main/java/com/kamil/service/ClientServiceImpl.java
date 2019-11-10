package com.kamil.service;

import com.kamil.dao.ClientDAO;
import com.kamil.dao.HibernateClientDAO;
import com.kamil.model.Client;

import java.util.List;

public class ClientServiceImpl implements ClientService {

    private ClientDAO clientDAO = new HibernateClientDAO();

    @Override
    public List<Client> getClients() {
        return clientDAO.getClients();
    }

    @Override
    public int addClient(Client client) {
        return clientDAO.addClient(client);
    }

    @Override
    public void deleteClient(int id) {
        clientDAO.deleteClient(id);
    }

    @Override
    public Client getClientById(int id) {
        return clientDAO.getClientById(id);
    }
}
