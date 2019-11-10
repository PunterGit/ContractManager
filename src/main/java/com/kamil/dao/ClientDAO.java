package com.kamil.dao;

import com.kamil.model.Client;

import java.util.List;

public interface ClientDAO {
    List<Client> getClients();
    int addClient(Client client);
    void deleteClient(int id);
    Client getClientById(int id);
}
