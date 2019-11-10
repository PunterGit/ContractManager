package com.kamil.dao;

import com.kamil.model.Client;
import com.kamil.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateClientDAO implements ClientDAO {

    @Override
    public List<Client> getClients() {
        Session currentSession = HibernateUtil.getSessionFactory().getCurrentSession();
        currentSession.beginTransaction();
        Query<Client> query = currentSession.createQuery("from Client order by name", Client.class);
        List<Client> clients = query.getResultList();
        currentSession.getTransaction().commit();
        return clients;
    }

    @Override
    public int addClient(Client client) {
        Session currentSession = HibernateUtil.getSessionFactory().getCurrentSession();
        currentSession.beginTransaction();
        System.out.println(client);
        currentSession.saveOrUpdate(client);
        currentSession.getTransaction().commit();
        return client.getId();
    }

    @Override
    public void deleteClient(int id) {
        Session currentSession = HibernateUtil.getSessionFactory().getCurrentSession();
        currentSession.beginTransaction();
        Query query = currentSession.createQuery("delete from Client where id=:clientId");
        query.setParameter("clientId", id);
        query.executeUpdate();
        currentSession.getTransaction().commit();
    }

    @Override
    public Client getClientById(int id) {
        Session currentSession = HibernateUtil.getSessionFactory().getCurrentSession();
        currentSession.beginTransaction();
        Client client = currentSession.get(Client.class, id);
        currentSession.getTransaction().commit();
        return client;
    }
}
