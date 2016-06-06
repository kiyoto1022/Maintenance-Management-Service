package com.service.maintenance.domain.model.maintenance.contract;

import java.util.List;

public interface ContractRepository {
	
	void recordRequest(Contract maintenanceContract);
	Contract findBy(ContractId id);
	List<Contract> list();
	
}