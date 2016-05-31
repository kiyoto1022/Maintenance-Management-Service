package com.service.maintenance.domain.model.maintenance.schedule;

import com.service.maintenance.domain.model.maintenance.contract.ContractId;

public class Schedule {

	private ContractId id;
	private int month;
	private int inspectionDay;
	
	public Schedule(ContractId id, int month, int day) {
		this.id = id;
		this.month = month;
		this.inspectionDay = day;
	}

	public Reminded toRemind(int day) {
		return new Reminded(inspectionDay, day);
	}
}