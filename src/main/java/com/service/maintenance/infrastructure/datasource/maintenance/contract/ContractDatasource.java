package com.service.maintenance.infrastructure.datasource.maintenance.contract;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.maintenance.domain.model.maintenance.contract.Contract;
import com.service.maintenance.domain.model.maintenance.contract.ContractId;
import com.service.maintenance.domain.model.maintenance.contract.ContractRepository;

@Repository
public class ContractDatasource implements ContractRepository {

	@Autowired
	ContractMapper mapper;
	
	@Override
	public Contract findBy(ContractId id) {
		return mapper.findBy(id);
	}
	
	@Override
	public void recordRequest(Contract maintenanceContract) {
		mapper.register(maintenanceContract);
	}

	@Override
	public List<Contract> list() {
		return mapper.list();
	}

}