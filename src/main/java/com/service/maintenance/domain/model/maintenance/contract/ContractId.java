package com.service.maintenance.domain.model.maintenance.contract;

public class ContractId {

	private Long value;

	public ContractId() {}
	
	public ContractId(Long value) {
		this.value = value;
	}
	
	public Long value() {
		return value;
	}
}