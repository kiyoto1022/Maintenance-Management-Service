
package com.service.maintenance.domain.model.maintenance.contract;

import java.util.List;

import com.service.maintenance.domain.model.maintenance.plan.InspectionMonth;
import com.service.maintenance.domain.model.maintenance.plan.Plan;

public class Contract {

	private ContractId id;
	private String name;
	private int fiscalYear;
	private int amount;
	private int maintenanceRate;
	
	public Contract() {}
	
	public Contract(ContractId id, String name, int fiscalYear, int amount, int rate) {
		this.id = id;
		this.name = name;
		this.fiscalYear = fiscalYear;
		this.amount = amount;
		this.maintenanceRate = rate;
	}
	
	public ContractId id() {
		return id;
	}
	
	public String name() {
		return name;
	}
	
	public int fiscalYear() {
		return fiscalYear;
	}
	
	public int amount() {
		return amount;
	}
	
	public int maintenanceRate() {
		return maintenanceRate;
	}
	
	public Plan planning(List<InspectionMonth> months) {
		return new Plan(id, months);
	}
}