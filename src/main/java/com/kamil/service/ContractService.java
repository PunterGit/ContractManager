package com.kamil.service;

import com.kamil.model.Contract;

import java.util.List;

public interface ContractService {
    List<Contract> getContracts();
    void addContract(Contract contract);
    void deleteContract(int id);
    Contract getContractById(int id);
}
