package com.kamil.service;

import com.kamil.dao.ContractDAO;
import com.kamil.dao.HibernateContractDAO;
import com.kamil.model.Contract;

import java.util.List;

public class ContractServiceImpl implements ContractService {

    private ContractDAO contractDAO = new HibernateContractDAO();

    @Override
    public List<Contract> getContracts() {
        return contractDAO.getContracts();
    }

    @Override
    public void addContract(Contract contract) {
        contractDAO.addContract(contract);
    }

    @Override
    public void deleteContract(int id) {
        contractDAO.deleteContract(id);
    }

    @Override
    public Contract getContractById(int id) {
        return contractDAO.getContractById(id);
    }
}
