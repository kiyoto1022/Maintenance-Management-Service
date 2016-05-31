package com.service.maintenance.domain.model.maintenance.contract;

public interface ContractRepository {
	
	void recordRequest(Contract maintenanceContract);
	Contract findBy(ContractId id);
	
}