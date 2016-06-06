package com.service.maintenance.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.maintenance.domain.model.maintenance.contract.Contract;
import com.service.maintenance.domain.model.maintenance.contract.ContractFactory;
import com.service.maintenance.domain.model.maintenance.contract.ContractId;
import com.service.maintenance.domain.model.maintenance.contract.ContractRepository;

@Service
public class ContractService {

	@Autowired
	ContractFactory factory;
	
	@Autowired
	ContractRepository repository;

	public Contract generate(String name, int fiscalYear, int amount, int rate) {
		return factory.generate(name, fiscalYear, amount, rate);
	}
	
	public void recordRequest(Contract maintenanceContract) {
		repository.recordRequest(maintenanceContract);
	}
	
	public Contract confirmTo(ContractId id) {
		return repository.findBy(id);
	}
	
	public List<Contract> list() {
		return repository.list();
	}
}