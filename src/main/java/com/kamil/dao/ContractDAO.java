package com.kamil.dao;

import com.kamil.model.Contract;

import java.util.List;

public interface ContractDAO {
    List<Contract> getContracts();
    void addContract(Contract contract);
    void deleteContract(int id);
    Contract getContractById(int id);
}
