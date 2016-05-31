package com.service.maintenance.domain.model.maintenance.plan;

import com.service.maintenance.domain.model.maintenance.contract.ContractId;

public interface PlanRepository {

	Plan findBy(ContractId id);
	void recordRequest(Plan plan);
	
}