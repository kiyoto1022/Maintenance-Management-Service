package com.service.maintenance.presentation.view.maintenance.contract;

import java.util.List;
import java.util.stream.Collectors;

import com.service.maintenance.domain.model.maintenance.contract.Contract;

public class ContractResponse {

	public Long id;
	public String name;
	public int fiscalYear;
	public int amount;
	public int maintenanceRate;
	
	public ContractResponse() {}
	
	public ContractResponse(Contract model) {
		this.id = model.id().value();
		this.name = model.name();
		this.fiscalYear = model.fiscalYear();
		this.amount = model.amount();
		this.maintenanceRate = model.maintenanceRate();
	}
	
	public static List<ContractResponse> from(List<Contract> contracts) {
		return contracts.stream().map(c -> new ContractResponse(c)).collect(Collectors.toList());
	}
	
}