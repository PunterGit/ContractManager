package com.kamil.service;

import com.kamil.model.Client;

import java.util.List;

public interface ClientService {
    List<Client> getClients();
    int addClient(Client client);
    void deleteClient(int id);
    Client getClientById(int id);
}
