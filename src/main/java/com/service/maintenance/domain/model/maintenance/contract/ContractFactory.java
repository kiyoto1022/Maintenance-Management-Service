package com.service.maintenance.domain.model.maintenance.contract;

public interface ContractFactory {
	
	Contract generate(String name, int fiscalYear, int amount, int rate);
	
}