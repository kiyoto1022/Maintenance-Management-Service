package com.service.maintenance.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.maintenance.domain.model.maintenance.contract.Contract;
import com.service.maintenance.domain.model.maintenance.contract.ContractId;
import com.service.maintenance.domain.model.maintenance.contract.ContractRepository;
import com.service.maintenance.domain.model.maintenance.plan.InspectionMonth;
import com.service.maintenance.domain.model.maintenance.plan.Plan;
import com.service.maintenance.domain.model.maintenance.plan.PlanRepository;

@Service
public class PlanService {
	
	@Autowired
	ContractRepository contractRepository;
	
	@Autowired
	PlanRepository planRepository;

	public void planning(ContractId id, List<InspectionMonth> months) {
		Contract contract = contractRepository.findBy(id);
		Plan plan = contract.planning(months);
		planRepository.recordRequest(plan);
	}
	
	public Plan confirmTo(ContractId id) {
		return planRepository.findBy(id);
	}
}