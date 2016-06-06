package com.service.maintenance.presentation.view;

public class ContractRegistForm {
	
	private String name;
	private int fiscalYear;
	private int amount;
	private int rate;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getFiscalYear() {
		return fiscalYear;
	}
	
	public void setFiscalYear(int fiscalYear) {
		this.fiscalYear = fiscalYear;
	}
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public int getRate() {
		return rate;
	}
	
	public void setRate(int rate) {
		this.rate = rate;
	}
}