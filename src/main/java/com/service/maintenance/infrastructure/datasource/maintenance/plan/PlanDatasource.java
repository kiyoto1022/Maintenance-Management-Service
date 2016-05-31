package com.service.maintenance.infrastructure.datasource.maintenance.plan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.maintenance.domain.model.maintenance.contract.ContractId;
import com.service.maintenance.domain.model.maintenance.plan.Plan;
import com.service.maintenance.domain.model.maintenance.plan.PlanRepository;

@Repository
public class PlanDatasource implements PlanRepository {

	@Autowired
	PlanMapper mapper;
	
	@Override
	public void recordRequest(Plan plan) {
		mapper.register(plan);
	}

	@Override
	public Plan findBy(ContractId id) {
		return mapper.findBy(id);
	}

}