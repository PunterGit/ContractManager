package com.kamil.dao;

import com.kamil.model.Contract;
import com.kamil.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateContractDAO implements ContractDAO {

    @Override
    public List<Contract> getContracts() {
        Session currentSession = HibernateUtil.getSessionFactory().getCurrentSession();
        currentSession.beginTransaction();
        Query<Contract> query = currentSession.createQuery("from Contract order by id", Contract.class);
        List<Contract> contracts = query.getResultList();
        currentSession.getTransaction().commit();
        return contracts;
    }

    @Override
    public void addContract(Contract contract) {
        Session currentSession = HibernateUtil.getSessionFactory().getCurrentSession();
        currentSession.beginTransaction();
        System.out.println(contract);
        currentSession.saveOrUpdate(contract);
        currentSession.getTransaction().commit();
    }

    @Override
    public void deleteContract(int id) {
        Session currentSession = HibernateUtil.getSessionFactory().getCurrentSession();
        currentSession.beginTransaction();
        Query query = currentSession.createQuery("delete from Contract where id=:contractId");
        query.setParameter("contractId", id);
        query.executeUpdate();
        currentSession.getTransaction().commit();
    }

    @Override
    public Contract getContractById(int id) {
        Session currentSession = HibernateUtil.getSessionFactory().getCurrentSession();
        currentSession.beginTransaction();
        Contract contract = currentSession.get(Contract.class, id);
        currentSession.getTransaction().commit();
        return contract;
    }
}
