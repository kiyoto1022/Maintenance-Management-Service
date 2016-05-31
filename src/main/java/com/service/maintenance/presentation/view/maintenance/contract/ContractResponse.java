package com.service.maintenance.presentation.view.maintenance.contract;

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
	
}