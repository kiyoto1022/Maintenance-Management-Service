package com.service.maintenance.infrastructure.datasource.maintenance.plan;

import org.apache.ibatis.annotations.Param;

import com.service.maintenance.domain.model.maintenance.contract.ContractId;
import com.service.maintenance.domain.model.maintenance.plan.Plan;

public interface PlanMapper {

	Plan findBy(@Param("id") ContractId id);
	void register(@Param("plan") Plan plan);
	
}