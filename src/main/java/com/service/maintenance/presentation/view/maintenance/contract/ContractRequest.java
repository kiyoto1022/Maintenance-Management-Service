package com.service.maintenance.presentation.view.maintenance.contract;

public class ContractRequest {

	public String name;
	public int fiscalYear;
	public int amount;
	public int maintenanceRate;
	
	public ContractRequest() {}
	
	public ContractRequest(String name, int fiscalYear, int amount, int rate) {
		this.name = name;
		this.fiscalYear = fiscalYear;
		this.amount = amount;
		this.maintenanceRate = rate;
	}
	
	@Override
    public String toString() {
        return "ContractRequest{" +
                "name=" + name +
                ", fiscalYear='" + fiscalYear + '\'' +
                ", amount='" + amount + '\'' +
                ", maintenanceRate='" + maintenanceRate + '\'' +
                '}';
    }
}