package com.service.maintenance.infrastructure.datasource.maintenance.contract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.service.maintenance.domain.model.maintenance.contract.Contract;
import com.service.maintenance.domain.model.maintenance.contract.ContractFactory;
import com.service.maintenance.domain.model.maintenance.contract.ContractId;

@Component
public class SequenceBaseContractFactory implements ContractFactory {

	@Autowired
	ContractMapper mapper;
	
	@Override
	public Contract generate(String name, int fiscalYear, int amount, int rate) {
		return new Contract(new ContractId(mapper.generateRequestId()), name, fiscalYear, amount, rate);
	}
}